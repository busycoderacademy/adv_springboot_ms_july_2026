package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional //under the hood it use declaritive tx and aop
public class AccountServiceImpl implements  AccountService {

    private AccountRepo repo;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public AccountServiceImpl(AccountRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Account> getAll() {
        return repo.getAll();
    }

    @Override
    public Account getById(int id) {
        long start=System.currentTimeMillis();

        Account account= repo.getById(id);

        if(account==null) {
            throw new BankAccountNotFoundException("Account not found");
        }
        long end=System.currentTimeMillis();
        logger.info("Time taken to get account by id: "+(end-start));
        return account;
    }

    @Override
    public void deposit(int id, BigDecimal amount) {
        Account account= getById(id);
        account.setBalance(account.getBalance().add(amount));
        repo.update(account);
    }

    @Override
    public void withdraw(int id, BigDecimal amount) {
        Account account= getById(id);
        account.setBalance(account.getBalance().subtract(amount));
        repo.update(account);
    }

    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        long start=System.currentTimeMillis();

        Account fromAcc= getById(fromId);
        Account toAcc= getById(toId);
        fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
        toAcc.setBalance(toAcc.getBalance().add(amount));
        repo.update(fromAcc);

        repo.update(toAcc);

        long end=System.currentTimeMillis();
        logger.info("Time taken to transfer method is  "+(end-start)+ "ms");
    }
}
