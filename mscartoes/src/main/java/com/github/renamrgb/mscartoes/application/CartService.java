package com.github.renamrgb.mscartoes.application;

import com.github.renamrgb.mscartoes.domain.Cart;
import com.github.renamrgb.mscartoes.infra.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    @Transactional
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getCartsByIncomeLesserEqual(Long income) {
        BigDecimal incomeBigDecimal = BigDecimal.valueOf(income);
        return cartRepository.findByIncomeLessThanEqual(incomeBigDecimal);
    }

}
