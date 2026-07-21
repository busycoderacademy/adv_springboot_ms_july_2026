package com.bankapp.service;

import com.bankapp.dto.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    public List<Account> getAll();
    public Account getById(int id);
    //deposit
    public void deposit(int id, BigDecimal amount);
    //withdraw
    public void withdraw(int id, BigDecimal amount);
    //transfer
    public void transfer(int fromId, int toId, BigDecimal amount);
}
