package br.com.mscredit_appraiser.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardIssuanceData {
    private Long idCard;
    private String cpf;
    private String address;
    private BigDecimal freeLimit;
}
