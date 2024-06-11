package br.com.mscredit_appraiser.controller;

import br.com.mscredit_appraiser.model.*;
import br.com.mscredit_appraiser.service.CreditAppraiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok().body(clientSituation);
    }

    @PostMapping
    public ResponseEntity<ClientAssessment> carryOutAssessment(@RequestBody AssessmentData data){
        ClientAssessment clientAssessment = creditAppraiserService.carryOutAssessment(data.getCpf(), data.getIncome());
        return ResponseEntity.ok().body(clientAssessment);
    }

    @PostMapping(value = "request-card")
    public ResponseEntity<CardIssuanceProtocol> requestCard(@RequestBody CardIssuanceData data){
        try {
            CardIssuanceProtocol cardIssuanceProtocol = creditAppraiserService.requestCardIssuance(data);
            return ResponseEntity.ok().body(cardIssuanceProtocol);
        }
        catch (RuntimeException e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
