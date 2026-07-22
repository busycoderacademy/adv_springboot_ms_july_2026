package com.bankapp.repo;

import com.bankapp.entities.Account;

import java.util.List;

public interface AccountRepo {
    //crud methods
    public List<Account> findAll();
    public  Account findById(int id);
    Account update(Account account);
    Account save(Account account);
}
