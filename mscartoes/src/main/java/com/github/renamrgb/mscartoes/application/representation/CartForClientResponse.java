package com.github.renamrgb.mscartoes.application.representation;

import com.github.renamrgb.mscartoes.domain.ClientCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartForClientResponse {
    private String name;
    private String flag;
    private BigDecimal approvedLimit;

    public static CartForClientResponse fromModel(ClientCart model) {
        return new CartForClientResponse(
                model.getCart().getName(),
                model.getCart().getFlag().toString(),
                model.getApprovedLimit()
        );
    }
}
