package br.com.mscredit_appraiser.client;

import br.com.mscredit_appraiser.model.ApprovedCards;
import br.com.mscredit_appraiser.model.Card;
import br.com.mscredit_appraiser.model.ClientCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscards", path = "/cards")
public interface CardResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCard>> findCardsByCpf(@RequestParam("cpf") String cpf);

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> findCardsWithIncomeUpTo(@RequestParam("income") Long income);
}
