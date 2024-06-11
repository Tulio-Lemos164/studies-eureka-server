package br.com.mscredit_appraiser.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @NoArgsConstructor
public class ApprovedCards {

    private String name;
    private String brand;
    private BigDecimal ApprovedLimit;
}
