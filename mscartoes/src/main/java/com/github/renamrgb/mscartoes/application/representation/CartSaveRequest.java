package com.github.renamrgb.mscartoes.application.representation;

import com.github.renamrgb.mscartoes.domain.Cart;
import com.github.renamrgb.mscartoes.domain.FlagCart;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartSaveRequest {
    private String name;
    private FlagCart flag;
    private BigDecimal income;
    private BigDecimal baseLimit;

    public Cart toModel() {
        return new Cart(name, flag, income, baseLimit);
    }
}
