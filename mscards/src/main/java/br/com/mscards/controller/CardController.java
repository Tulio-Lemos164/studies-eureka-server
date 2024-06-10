package br.com.mscards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok().body("Okey-Dokey");
    }
}
