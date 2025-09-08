package com.example.spring_ch12_ex3.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Purchase {

    private int id;
    private String product;
    private BigDecimal price;
}
