package com.github.renamrgb.mscartoes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private FlagCart flag;
    private BigDecimal income;
    private BigDecimal baseLimit;

    public Cart(String name, FlagCart flag, BigDecimal income, BigDecimal baseLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.baseLimit = baseLimit;
    }
}
