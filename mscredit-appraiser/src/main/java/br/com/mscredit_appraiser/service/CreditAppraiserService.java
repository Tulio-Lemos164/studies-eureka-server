package br.com.mscredit_appraiser.service;

import br.com.mscredit_appraiser.client.CardResourceClient;
import br.com.mscredit_appraiser.client.ClientResourceClient;
import br.com.mscredit_appraiser.model.ClientCard;
import br.com.mscredit_appraiser.model.ClientData;
import br.com.mscredit_appraiser.model.ClientSituation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAppraiserService {

    @Autowired
    private ClientResourceClient clientResource;

    @Autowired
    private CardResourceClient cardResource;

    public ClientSituation getClientSituation(String cpf) {
        ResponseEntity<ClientData> clientData = clientResource.findByCpf(cpf);
        ResponseEntity<List<ClientCard>> clientCard = cardResource.findCardsByCpf(cpf);

        return ClientSituation.builder()
                .client(clientData.getBody())
                .cards(clientCard.getBody())
                .build();
    }
}
