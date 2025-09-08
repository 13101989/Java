package com.example.spring_ch14_ex1.controllers;

import com.example.spring_ch14_ex1.models.Account;
import com.example.spring_ch14_ex1.models.TransferRequest;
import com.example.spring_ch14_ex1.services.TransferService;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) throws AccountNotFoundException {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {

        if (name == null) {
            return transferService.getAllAccounts();
        }
        return transferService.findAccountsByName(name);
    }
}
