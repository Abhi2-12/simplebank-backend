package com.simplebank.controller;

import com.simplebank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplebank.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @PostMapping("/request")
    public Account requestAccount(@RequestParam Long userId) {
        return accountService.requestAccount(userId);
    }
    
}
