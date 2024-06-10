package br.com.mscards.dto.request;

import br.com.mscards.model.enums.Brand;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CardRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private Brand brand;

    @NotBlank
    private BigDecimal income;

    @NotBlank
    private BigDecimal basicLimit;
}
