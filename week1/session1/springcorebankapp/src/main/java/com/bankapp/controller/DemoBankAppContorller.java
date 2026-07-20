package com.bankapp.controller;

import com.bankapp.config.AppConfig;
import com.bankapp.repo.AccountRepo;
import com.bankapp.repo.impl.AccountRepoMapImpl;
import com.bankapp.service.AccountService;
import com.bankapp.service.AccountServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class DemoBankAppContorller {
    public static void main(String[] args) {
        //i want sprng should take the controll

        //create the context
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService accountService=context.getBean("accountService", AccountService.class);

        //print all accounts
        accountService.getAll().forEach(System.out::println);
        //accountService.transfer(2, 3, new BigDecimal(1000));
    }
}
