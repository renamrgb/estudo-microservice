package com.github.renamrbg.msavaliadorcredito.application;

import com.github.renamrbg.msavaliadorcredito.domain.model.ClientSituation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-ratings")
@AllArgsConstructor
public class CreditRating {

    private final CreditRatingService CreditRatingService;

    @GetMapping
    public String status () {
        return "ok";
    }

    @GetMapping(value = "situation-client", params = "cpf")
    public ResponseEntity<ClientSituation> getSituationClient(@RequestParam("cpf") String cpf) {
        ClientSituation clientSituation = CreditRatingService.getSituationClient(cpf);
    }
}
