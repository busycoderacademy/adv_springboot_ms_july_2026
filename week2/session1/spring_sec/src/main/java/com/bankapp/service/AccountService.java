package com.bankapp.service;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public  Account findById(int id);

    public void create(Account account);

    public void deposit(int id, BigDecimal amount);

    public void withdraw(int id, BigDecimal amount);

    public void transfer(int fromId, int toId, BigDecimal amount);

    public void delete(int id);
}
