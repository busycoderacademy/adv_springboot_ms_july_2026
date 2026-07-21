package com.bankapp.controller;

import com.bankapp.dto.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankTransactionController {
    private AccountService accountService;

    @Autowired
    public BankTransactionController(AccountService accountService) {
        this.accountService = accountService;
    }
    //get all accounts
    @GetMapping("/accounts")
    public List<Account> getAll() {
        return accountService.getAll();
    }
}
