package br.com.mscredit_appraiser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class ClientAssessment {
    private List<ApprovedCards> cards;
}
