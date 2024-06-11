package br.com.mscredit_appraiser.service;

import br.com.mscredit_appraiser.client.CardResourceClient;
import br.com.mscredit_appraiser.client.ClientResourceClient;
import br.com.mscredit_appraiser.model.*;
import br.com.mscredit_appraiser.mqueue.RequestCardIssuancePublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CreditAppraiserService {

    @Autowired
    private ClientResourceClient clientResource;

    @Autowired
    private CardResourceClient cardResource;

    @Autowired
    private RequestCardIssuancePublisher cardIssuancePublisher;

    public ClientSituation getClientSituation(String cpf) {
        ResponseEntity<ClientData> clientData = clientResource.findByCpf(cpf);
        ResponseEntity<List<ClientCard>> clientCard = cardResource.findCardsByCpf(cpf);

        return ClientSituation.builder()
                .client(clientData.getBody())
                .cards(clientCard.getBody())
                .build();
    }

    public ClientAssessment carryOutAssessment(String cpf, Long income){
        ResponseEntity<ClientData> clientResponse = clientResource.findByCpf(cpf);
        ResponseEntity<List<Card>> cardsResponse = cardResource.findCardsWithIncomeUpTo(income);

        List<Card> cards = cardsResponse.getBody();
        List<ApprovedCards> approvedCards = cards.stream().map(card -> {

            BigDecimal basicLimit = card.getBasicLimit();
            BigDecimal ageBD = BigDecimal.valueOf((clientResponse.getBody().getAge())/10);
            BigDecimal approvedLimit = ageBD.multiply(basicLimit);

            ApprovedCards approvedCard = new ApprovedCards();
            approvedCard.setName(card.getName());
            approvedCard.setBrand(card.getBrand());
            approvedCard.setApprovedLimit(approvedLimit);

            return approvedCard;
        }).collect(Collectors.toList());

        return new ClientAssessment(approvedCards);
    }

    public CardIssuanceProtocol requestCardIssuance(CardIssuanceData data){
        try {
            cardIssuancePublisher.requestCardIssuance(data);
            String protocol = UUID.randomUUID().toString();
            return new CardIssuanceProtocol(protocol);
        }
        catch (JsonProcessingException e){
            throw new RuntimeException();
        }
    }
}
