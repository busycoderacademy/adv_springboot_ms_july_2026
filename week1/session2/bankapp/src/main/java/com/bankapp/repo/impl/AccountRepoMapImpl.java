package com.bankapp.repo.impl;

import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@Profile("dev")
@Repository
public class AccountRepoMapImpl implements AccountRepo {

    private Map<Integer, Account> map = new HashMap<>();
    //init that hashmap
    public AccountRepoMapImpl() {
        map.put(1, new Account(1, "raj", new BigDecimal(1000)));
        map.put(2, new Account(2, "ekta", new BigDecimal(1000)));
    }
    @Override
    public List<Account> getAll() {
        System.out.println("Map");
        return map.values().stream().toList();
    }

    @Override
    public Account getById(int id) {
        return map.get(id);
    }

    @Override
    public void update(Account account) {
        map.put(account.getId(), account);
    }
}
