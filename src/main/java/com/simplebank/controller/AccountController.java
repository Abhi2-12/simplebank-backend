package com.simplebank.controller;

import com.simplebank.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.simplebank.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @PostMapping("/request")
    public Account requestAccount(@RequestParam Long userId) {
        return accountService.requestAccount(userId);
    }

    @PutMapping("admin/approve/{id}")
    public Account approveAccount(@PathVariable Long id) {
        return accountService.approveAccount(id);
    }
    
    @PostMapping("/deposit")
    public Account deposit(@RequestParam(required = true) Long accountId,
                           @RequestParam(required = true) double amount) {
        return accountService.deposit(accountId, amount);
    } 
    
    @PostMapping("/withdraw")
    public Account withdraw(@RequestParam Long accountId, 
                            @RequestParam double amount) {
        return accountService.withdrow(accountId, amount);
    }   
}
