package br.com.msclients.dto.mapper;

import br.com.msclients.dto.request.ClientRequestDTO;
import br.com.msclients.model.Client;
import org.modelmapper.ModelMapper;

public class ClientMapper {

    public static Client toClient(ClientRequestDTO dto) {
        return new ModelMapper().map(dto, Client.class);
    }
}
