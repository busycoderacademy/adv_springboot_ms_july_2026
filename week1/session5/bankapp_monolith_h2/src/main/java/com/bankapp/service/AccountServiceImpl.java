package com.bankapp.service;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import com.bankapp.util.AccountConverter;
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
    public List<AccountDto> findAll() {
        return accountRepo.findAll().stream().map(AccountConverter::convert).toList();
    }

    @Override
    public AccountDto findById(int id) {
       return accountRepo.findById(id)
               .map(AccountConverter::convert)
                .orElseThrow(()-> new BankAccountNotFoundException("account with id "+ id +" is not found"));
    }

    @Override
    public void create(AccountDto accountDto) {
        accountRepo.save(AccountConverter.convert(accountDto));
    }

    @Override
    public void deposit(int id, BigDecimal amount) {
        Account account = accountRepo.findById(id)
                .orElseThrow(()-> new BankAccountNotFoundException("account with id "+ id +" is not found"));
        account.setBalance(account.getBalance().add(amount));
        accountRepo.save(account);
    }

    @Override
    public void withdraw(int id, BigDecimal amount) {
        Account account =  accountRepo.findById(id)
                .orElseThrow(()-> new BankAccountNotFoundException("account with id "+ id +" is not found"));
        account.setBalance(account.getBalance().subtract(amount));
        accountRepo.save(account);
    }
    @Override
    public void transfer(int fromId, int toId, BigDecimal amount) {
        //get both account
        Account fromAccount =  accountRepo.findById(fromId)
                .orElseThrow(()-> new BankAccountNotFoundException("account with id "+ fromId +" is not found"));

        Account toAccount =  accountRepo.findById(toId)
                .orElseThrow(()-> new BankAccountNotFoundException("account with id "+ toId +" is not found"));

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));
        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);
    }

    @Override
    public void delete(int id) {
        Account toAccount =  accountRepo.findById(id)
                .orElseThrow(()-> new BankAccountNotFoundException("account with id "+ id +" is not found"));
        accountRepo.delete(toAccount);
    }
}
