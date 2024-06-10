package br.com.msclients.service;

import br.com.msclients.exception.CpfUniqueViolationException;
import br.com.msclients.exception.ResourceNotFoundException;
import br.com.msclients.model.Client;
import br.com.msclients.repository.ClientRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client insert(Client client){
        try {
            return clientRepository.save(client);
        }
        catch (DataIntegrityViolationException e){
            throw new CpfUniqueViolationException("This cpf is already in use");
        }
    }

    @Transactional(readOnly = true)
    public Client findByCpf(String cpf){
        return clientRepository.findByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException("No client with the request cpf was found"));
    }
}
