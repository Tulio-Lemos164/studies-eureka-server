package br.com.mscredit_appraiser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class Card {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal income;
    private BigDecimal basicLimit;
}
