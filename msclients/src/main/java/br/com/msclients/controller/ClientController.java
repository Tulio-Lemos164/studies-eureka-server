package br.com.msclients.controller;

import br.com.msclients.dto.mapper.ClientMapper;
import br.com.msclients.dto.request.ClientRequestDTO;
import br.com.msclients.model.Client;
import br.com.msclients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok().body("Okey-Dokey");
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody ClientRequestDTO obj){
        Client client = clientService.insert(ClientMapper.toClient(obj));
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Client> findByCpf(@PathVariable String cpf){
        Client client = clientService.findByCpf(cpf);
        return ResponseEntity.ok().body(client);
    }
}
