package com.example.spring_ch11_payments.controllers;

import com.example.spring_ch11_payments.models.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentsController {

    private static final Logger logger = Logger.getLogger(PaymentsController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    ) {
        logger.info("Received request with id " + requestId + " ;Payment amount: " + payment.getAmount());

        payment.setId(requestId);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("requestId", requestId)
                .body(payment);
    }
}



