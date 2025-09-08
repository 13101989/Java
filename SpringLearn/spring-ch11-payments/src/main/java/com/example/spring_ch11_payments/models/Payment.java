package com.example.spring_ch11_payments.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    private String id;
    private double amount;
}
