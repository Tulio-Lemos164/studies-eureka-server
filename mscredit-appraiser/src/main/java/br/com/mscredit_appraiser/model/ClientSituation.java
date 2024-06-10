package br.com.mscredit_appraiser.model;

import lombok.Data;

import java.util.List;

@Data
public class ClientSituation {
    private ClientData client;
    private List<ClientCard> cards;
}
