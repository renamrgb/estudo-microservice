package com.github.renamrgb.mscartoes.infra.repository;

import com.github.renamrgb.mscartoes.domain.ClientCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCartRepository extends JpaRepository<ClientCart, Long> {
    List<ClientCart> findByCpf(String cpf);
}
