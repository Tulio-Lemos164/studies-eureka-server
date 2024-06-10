package br.com.mscards.dto.mapper;

import br.com.mscards.dto.request.CardRequestDTO;
import br.com.mscards.model.Card;
import org.modelmapper.ModelMapper;

public class CardMapper {

    public static Card toCard(CardRequestDTO dto) {
        return new ModelMapper().map(dto, Card.class);
    }
}
