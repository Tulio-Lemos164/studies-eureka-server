package br.com.mscards.dto.response;

import br.com.mscards.model.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardsByClientsResponseDTO {

    private String name;
    private String brand;
    private BigDecimal freeLimit;

    public static  CardsByClientsResponseDTO fromModel(ClientCard card){
        return new CardsByClientsResponseDTO(
                card.getCard().getName(),
                card.getCard().getBrand().toString(),
                card.getBasicLimit()
        );
    }
}
