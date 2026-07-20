package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.impl.AccountRepoMapImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
//OCP, pull vs push
@Service("accountService")
//@Scope("prototype")
@Transactional //acid=Transactional is a way to handle in graceful declarive way :)
//why hell it is working?

public class AccountServiceImpl implements  AccountService {

    private AccountRepo accountRepo;
    private Logger logger= LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }
    //code tangling : business logic should not be mixed with logging
    @Override
    public List<Account> getAll() {
        long start=System.currentTimeMillis();

        List<Account> accounts= accountRepo.getAll();

        long end=System.currentTimeMillis();
        logger.info("All accounts: {}", accounts+ " time taken "+ (end-start)+" ms");
        return accounts;
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepo.getAccountById(id);
    }

    @Override
    public void deposit(int id, BigDecimal amount) {
        Account account=getAccountById(id);
        account.setBalance(account.getBalance().add(amount));
        accountRepo.update(account);
    }

    @Override
    public void withdraw(int id, BigDecimal amount) {
        Account account=getAccountById(id);
        account.setBalance(account.getBalance().subtract(amount));
        accountRepo.update(account);
    }

    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        Account fromAccount=getAccountById(fromId);
        Account toAccount=getAccountById(toId);
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        accountRepo.update(fromAccount);
        if(1==1){
            throw new RuntimeException("Something went wrong");
        }
        accountRepo.update(toAccount);
    }
}
