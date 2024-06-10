package br.com.mscards.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CardsByClientsResponseDTO {

    private String name;
    private String brand;
    private BigDecimal freeLimit;
}
