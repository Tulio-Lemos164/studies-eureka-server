package br.com.mscards.service;

import br.com.mscards.model.ClientCard;
import br.com.mscards.repository.ClientCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardService {

    @Autowired
    private ClientCardRepository clientCardRepository;

    public List<ClientCard> listCardsByCpf(String cpf){
        return clientCardRepository.findByCpf(cpf);
    }
}
