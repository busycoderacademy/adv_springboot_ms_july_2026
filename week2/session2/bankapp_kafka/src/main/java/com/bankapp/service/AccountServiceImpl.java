package com.bankapp.service;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;
import com.bankapp.events.FundTransferEvent;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import com.bankapp.util.AccountConverter;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

//SL=BL+ CCC
@Service
@Transactional
public class AccountServiceImpl implements  AccountService{
    private final AccountRepo accountRepo;
    private final KafkaTemplate<String, FundTransferEvent> kafkaTemplate;


    public AccountServiceImpl(AccountRepo accountRepo, KafkaTemplate<String, FundTransferEvent> kafkaTemplate) {
        this.accountRepo = accountRepo;
        this.kafkaTemplate = kafkaTemplate;
    }


    //    private ApplicationEventPublisher applicationEventPublisher;


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
        // i want to publish this event FundTransferEvent
        FundTransferEvent fundTransferEvent =
                new FundTransferEvent(fromId, toId, amount, LocalDateTime.now());

        CompletableFuture<SendResult<String, FundTransferEvent>> future =
                kafkaTemplate.send("fund-transfer-events", fundTransferEvent);
        System.out.println("------------------------------------------------");
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Failed: " + ex.getMessage());
            } else {
                System.out.println("Broker ACK received");

                RecordMetadata metadata = result.getRecordMetadata();

                System.out.println("Topic     : " + metadata.topic());
                System.out.println("Partition : " + metadata.partition());
                System.out.println("Offset    : " + metadata.offset());
            }
        });

        //applicationEventPublisher.publishEvent(fundTransferEvent);

    }

    @Override
    public void delete(int id) {
        Account toAccount =  accountRepo.findById(id)
                .orElseThrow(()-> new BankAccountNotFoundException("account with id "+ id +" is not found"));
        accountRepo.delete(toAccount);
    }
}
