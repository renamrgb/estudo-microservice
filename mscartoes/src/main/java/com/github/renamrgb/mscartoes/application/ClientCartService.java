package com.github.renamrgb.mscartoes.application;

import com.github.renamrgb.mscartoes.domain.ClientCart;
import com.github.renamrgb.mscartoes.infra.repository.ClientCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCartService {

    private final ClientCartRepository repository;

    public List<ClientCart> findCartsByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
