package br.com.mscards.dto.mapper;

import br.com.mscards.dto.request.CardRequestDTO;
import br.com.mscards.dto.response.CardsByClientsResponseDTO;
import br.com.mscards.model.Card;
import br.com.mscards.model.ClientCard;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class CardMapper {

    public static Card toCard(CardRequestDTO dto) {
        return new ModelMapper().map(dto, Card.class);
    }

    public static CardsByClientsResponseDTO toDTO(ClientCard clientCard){
        PropertyMap<ClientCard, CardsByClientsResponseDTO> props = new PropertyMap<ClientCard, CardsByClientsResponseDTO>() {
            @Override
            protected void configure() {
                map().setBrand(clientCard.getCard().getBrand().name());
                map().setFreeLimit(clientCard.getBasicLimit());
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(clientCard, CardsByClientsResponseDTO.class);
    }
}
