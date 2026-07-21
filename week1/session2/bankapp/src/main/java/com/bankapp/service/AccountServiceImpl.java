package com.bankapp.service;

import com.bankapp.dto.Account;
import com.bankapp.events.FundTransferredEvent;
import com.bankapp.exceptions.AEx;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
//under the hood it use declaritive tx and aop
public class AccountServiceImpl implements  AccountService {

    private AccountRepo repo;

    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public AccountServiceImpl(AccountRepo repo, ApplicationEventPublisher eventPublisher) {
        this.repo = repo;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<Account> getAll() {
        return repo.getAll();
    }

    @Override
    public Account getById(int id) {
        Account account= repo.getById(id);

        if(account==null) {
            throw new BankAccountNotFoundException("Account not found");
        }
        return account;
    }

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT)
    @Override
    public void deposit(int id, BigDecimal amount) {
        Account account= getById(id);
        account.setBalance(account.getBalance().add(amount));
        repo.update(account);
    }
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    @Override
    public void withdraw(int id, BigDecimal amount) {
        Account account= getById(id);
        account.setBalance(account.getBalance().subtract(amount));
        repo.update(account);
    }
//noRollbackFor = {BankAccountNotFoundException.class}
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT, rollbackFor = {AEx.class},
    timeout = 1000)
    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        Account fromAcc= getById(fromId);
        Account toAcc= getById(toId);
        fromAcc.setBalance(fromAcc.getBalance().subtract(amount));

        toAcc.setBalance(toAcc.getBalance().add(amount));
        repo.update(fromAcc);
        repo.update(toAcc);

        //create event and publish it
        FundTransferredEvent event = new FundTransferredEvent(fromId, toId, amount);
        eventPublisher.publishEvent(event);

    }
}
