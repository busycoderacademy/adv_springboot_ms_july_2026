package com.bankapp.repo;

import com.bankapp.dto.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepo {
    public List<Account> getAll();
    public Account getAccountById(int id);
    public void update(Account account);
}
