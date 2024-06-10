package br.com.mscards.controller;

import br.com.mscards.dto.mapper.CardMapper;
import br.com.mscards.dto.request.CardRequestDTO;
import br.com.mscards.dto.response.CardsByClientsResponseDTO;
import br.com.mscards.model.Card;
import br.com.mscards.model.ClientCard;
import br.com.mscards.service.CardService;
import br.com.mscards.service.ClientCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private ClientCardService clientCardService;

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok().body("Okey-Dokey");
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CardRequestDTO obj){
        Card card = cardService.insert(CardMapper.toCard(obj));
        return ResponseEntity.status(201).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> findCardsWithIncomeUpTo(@RequestParam("income") Long income){
        List<Card> cardsList = cardService.findCardIncomeLowerOrEqualTo(income);
        return ResponseEntity.ok().body(cardsList);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardsByClientsResponseDTO>> findCardsByCpf(@RequestParam("cpf") String cpf){
        List<ClientCard> myList = clientCardService.listCardsByCpf(cpf);
        List<CardsByClientsResponseDTO> cardsList = new ArrayList<>();

        for(int i = 0; i< myList.size(); i++){
            cardsList.add(CardMapper.toDTO(myList.get(i)));
        }
        return ResponseEntity.ok().body(cardsList);
    }
}
