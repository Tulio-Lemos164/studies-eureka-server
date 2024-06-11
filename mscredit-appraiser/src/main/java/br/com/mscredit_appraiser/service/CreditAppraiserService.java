package br.com.mscredit_appraiser.service;

import br.com.mscredit_appraiser.client.ClientResourceClient;
import br.com.mscredit_appraiser.model.ClientData;
import br.com.mscredit_appraiser.model.ClientSituation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreditAppraiserService {

    @Autowired
    private ClientResourceClient clientResource;

    public ClientSituation getClientSituation(String cpf) {

        ResponseEntity<ClientData> response = clientResource.findByCpf(cpf);

        return ClientSituation.builder().client(response.getBody()).build();
    }
}
