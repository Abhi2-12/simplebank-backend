package com.simplebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplebank.enums.AccountStatus;
import com.simplebank.model.Account;
import com.simplebank.repository.AccountRepository;

import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    //Customer requests account
    public Account requestAccount(Long userId) {

        Account account = new Account();
        account.setUserId(userId);

        //generate random account number 
        account.setAccountNumber(UUID.randomUUID().toString());

        //set initial status
        account.setStatus(AccountStatus.PENDING);

        return accountRepository.save(account);
    }

    public Account approveAccount(Long accountId) {

        Account account = accountRepository.findById(accountId)
        .orElseThrow(() -> new RuntimeException("Account not found"));
        
        account.setStatus(AccountStatus.ACTIVE);

        return accountRepository.save(account);
    }

    public Account deposit(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
        .orElseThrow(() -> new RuntimeException("Account not found"));

        if(account.getStatus() != AccountStatus.ACTIVE) {
            throw new RuntimeException("Account not active");
        }

        account.setBalance(account.getBalance() + amount);

        return accountRepository.save(account);
    }

    public Account withdrow(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
        .orElseThrow(() -> new RuntimeException("Account not Found"));
//only active user can withdraw money
        if(account.getStatus() != AccountStatus.ACTIVE) {
            throw new RuntimeException("Account not active");
        }
//cant withdraw more than balance
        if(account.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        account.setBalance(account.getBalance() - amount);

        return accountRepository.save(account);
    }
}