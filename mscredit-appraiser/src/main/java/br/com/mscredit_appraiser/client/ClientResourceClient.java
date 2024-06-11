package br.com.mscredit_appraiser.client;

import br.com.mscredit_appraiser.model.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "msclients", path = "/clients")
public interface ClientResourceClient {

    @GetMapping(value = "/{cpf}")
    ResponseEntity<ClientData> findByCpf(@PathVariable String cpf);
}
