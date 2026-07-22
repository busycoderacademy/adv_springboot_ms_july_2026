package com.bankapp.service;

import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

//SL=BL+ CCC
@Service
@Transactional
public class AccountServiceImpl implements  AccountService{

    private AccountRepo accountRepo;

    @Autowired
    public void setAccountRepo(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }

    @Override
    public Account findById(int id) {
        Account account = accountRepo.findById(id);
        if(account==null){
            throw new BankAccountNotFoundException("account with id "+ id+" not found");
        }
        return account;
    }

    @Override
    public void create(Account account) {
        accountRepo.save(account);
    }

    @Override
    public void deposit(int id, BigDecimal amount) {
        Account account = findById(id);
        account.setBalance(account.getBalance().add(amount));
        accountRepo.update(account);
    }

    @Override
    public void withdraw(int id, BigDecimal amount) {
        Account account = findById(id);
        account.setBalance(account.getBalance().subtract(amount));
        accountRepo.update(account);
    }
    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        //get both account
        Account fromAccount = findById(fromId);
        Account toAccount = findById(toId);
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));
        accountRepo.update(fromAccount);
        accountRepo.update(toAccount);
    }
}
