package br.com.msclients.repository;

import br.com.msclients.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public Optional<Client> findByCpf(String cpf);
}
