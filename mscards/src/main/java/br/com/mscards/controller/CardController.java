package br.com.mscards.controller;

import br.com.mscards.dto.mapper.CardMapper;
import br.com.mscards.dto.request.CardRequestDTO;
import br.com.mscards.model.Card;
import br.com.mscards.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok().body("Okey-Dokey");
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CardRequestDTO obj){
        Card card = cardService.insert(CardMapper.toCard(obj));
        return ResponseEntity.status(201).build();
    }
}
