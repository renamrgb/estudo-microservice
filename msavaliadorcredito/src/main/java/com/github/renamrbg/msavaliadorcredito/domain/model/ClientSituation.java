package com.github.renamrbg.msavaliadorcredito.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class ClientSituation {
    private DataClient client;
    private List<CartClient> carts;
}
