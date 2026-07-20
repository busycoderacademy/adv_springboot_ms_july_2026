package com.bankapp.repo.impl;

import com.bankapp.dto.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepoJpaImpl implements AccountRepo{

    private Map<Integer, Account> accounts = new HashMap<>();
    //use ctr to insert two account holder raj and ekta with initial bal of 2000
    public AccountRepoJpaImpl() {
        accounts.put(1, new Account(1, "Raj", new BigDecimal(2000)));
        accounts.put(2, new Account(2, "Ekta", new BigDecimal(2000)));
    }

    @Override
    public List<Account> getAll() {
        System.out.println("getAll() called--jpa version");
        return new ArrayList<>(accounts.values());
    }

    @Override
    public Account getAccountById(int id) {
        //find the account on basis of id if not found throw the BankAccountNotFoundException
        Account account = accounts.get(id);
        if(account==null){
            throw new BankAccountNotFoundException("Account not found");
        }
        return account;
    }

    @Override
    public void update(Account account) {
        //update the account
        accounts.put(account.getId(), account);
    }


}
