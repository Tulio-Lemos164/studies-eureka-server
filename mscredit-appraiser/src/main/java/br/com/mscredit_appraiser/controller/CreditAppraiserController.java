package br.com.mscredit_appraiser.controller;

import br.com.mscredit_appraiser.model.ClientSituation;
import br.com.mscredit_appraiser.service.CreditAppraiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-ratings")
public class CreditAppraiserController {

    @Autowired
    private CreditAppraiserService creditAppraiserService;

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok().body("Okey-Dokey");
    }

    @GetMapping(value = "/client-situation",params = "cpf")
    public ResponseEntity<ClientSituation> consultClientSituation(@RequestParam("cpf") String cpf){
        ClientSituation clientSituation = creditAppraiserService.getClientSituation(cpf);
    }
}
