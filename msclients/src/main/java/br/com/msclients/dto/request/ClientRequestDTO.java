package br.com.msclients.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ClientRequestDTO {

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String name;

    @NotBlank
    private Integer age;
}
