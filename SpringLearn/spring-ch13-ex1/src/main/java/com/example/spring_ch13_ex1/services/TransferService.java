package com.example.spring_ch13_ex1.services;

import com.example.spring_ch13_ex1.models.Account;
import com.example.spring_ch13_ex1.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findAccountById(idSender);
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        accountRepository.changeAmount(idSender, senderNewAmount);

        Account receiver = accountRepository.findAccountById(idReceiver);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);

//        throw new RuntimeException("Oh no! Something went wrong!");
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAcounts();
    }
}
