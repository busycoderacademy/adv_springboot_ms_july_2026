package com.bankapp.controller;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountTransactionController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    //get all accounts
    @GetMapping("/accounts")
    public List<AccountDto> getAll(){
        return accountService.findAll();
    }

}
