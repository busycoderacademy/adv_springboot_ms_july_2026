package com.bankapp.util;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;

public class AccountConverter {
    //converts Account to AccountDto
    public static AccountDto convert(Account account) {
        return new AccountDto(account.getId(),
                account.getAccountHolderName(),
                account.getBalance(), account.getEmail(), account.getPhone());
    }

    //convert AccountDto to Account
    public static Account convert(AccountDto accountDto) {
        return new Account(accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance(), accountDto.getEmail(), accountDto.getPhone());
    }
}
