package com.github.renamrgb.msclientes.application;

import com.github.renamrgb.msclientes.domain.Client;
import com.github.renamrgb.msclientes.infra.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client save (Client client) {
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Optional<Client> getByCpf(String cpf) {
        return clientRepository.findByCpf(cpf);
    }
}
