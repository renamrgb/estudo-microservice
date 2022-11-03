package com.github.renamrgb.mscartoes.infra.repository;

import com.github.renamrgb.mscartoes.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByIncomeLessThanEqual(BigDecimal income);
}
