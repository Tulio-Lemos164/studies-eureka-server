package br.com.mscredit_appraiser.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class AssessmentData {

    private String cpf;
    private Long income;
}
