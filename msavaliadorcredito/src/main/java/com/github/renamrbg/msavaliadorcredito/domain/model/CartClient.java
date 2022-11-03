package com.github.renamrbg.msavaliadorcredito.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartClient {

    private String name;
    private String flag;
    private BigDecimal approvedLimit;
}
