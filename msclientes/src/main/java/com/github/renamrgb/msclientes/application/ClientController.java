package com.github.renamrgb.msclientes.application;

import com.github.renamrgb.msclientes.application.representation.ClientSaveRequest;
import com.github.renamrgb.msclientes.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    private final ClientService service;

    @GetMapping
    public String status() {
        log.info("Obtendo o staus do microservice de clients");
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest request) {
        Client client = request.toModel();
        service.save(client);

        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity findByCpf(@RequestParam("cpf") String cpf) {
        Optional<Client> clientOrNull = service.getByCpf(cpf);
        if (clientOrNull.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientOrNull);
    }
}
