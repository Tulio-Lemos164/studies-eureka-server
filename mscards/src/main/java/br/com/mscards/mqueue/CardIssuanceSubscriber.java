package br.com.mscards.mqueue;

import br.com.mscards.model.Card;
import br.com.mscards.model.CardIssuanceData;
import br.com.mscards.model.ClientCard;
import br.com.mscards.repository.CardRepository;
import br.com.mscards.repository.ClientCardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CardIssuanceSubscriber {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private ClientCardRepository clientCardRepository;

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void receiveIssuanceRequest(@Payload String payload){
        ObjectMapper mapper = new ObjectMapper();

        try {
            CardIssuanceData data = mapper.readValue(payload, CardIssuanceData.class);
            Card card = cardRepository.findById(data.getIdCard()).orElseThrow();
            ClientCard clientCard = new ClientCard();
            clientCard.setCard(card);
            clientCard.setCpf(data.getCpf());
            clientCard.setBasicLimit(data.getFreeLimit());

            clientCardRepository.save(clientCard);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
