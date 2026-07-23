package com.bankapp.controller;

import com.bankapp.dto.AccountDto;
import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//@Controller + @ResponseBody(trigger parser to convert java object to json/xml)
@RequestMapping("api/v1")
public class AccountTransactionController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
//    @GetMapping(path = "products", produces = {MediaType.APPLICATION_JSON_VALUE,
//            MediaType.APPLICATION_XML_VALUE})


    //deposit
    @PostMapping(path = "accounts/deposit")
    public void deposit(@RequestBody DepositDto depositDto) {
        accountService.deposit(depositDto.getId(), depositDto.getAmount());
    }

    //withdraw
    @PostMapping(path = "accounts/withdraw")
    public void withdraw(@RequestBody WithdrawDto withdrawDto) {
        accountService.withdraw(withdrawDto.getId(), withdrawDto.getAmount());
    }

    //transfer
    @PostMapping(path = "accounts/transfer")
    public void transfer(@RequestBody TransferDto transferDto) {
        accountService.transfer(transferDto.getFromAccountId(),
                transferDto.getToAccountId(), transferDto.getAmount());
    }


}
