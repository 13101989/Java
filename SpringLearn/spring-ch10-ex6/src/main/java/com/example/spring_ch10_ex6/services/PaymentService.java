package com.example.spring_ch10_ex6.services;

import com.example.spring_ch10_ex6.exceptions.NotEnoughMoneyException;
import com.example.spring_ch10_ex6.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() {
        throw new NotEnoughMoneyException();
    }
}
