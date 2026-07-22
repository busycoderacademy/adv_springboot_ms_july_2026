package com.bankapp;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
//		(exclude = {DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BankappApplication implements  CommandLineRunner {

	@Autowired
	private AccountService accountService;

	@Override
	public void run(String... args) throws Exception {
//		accountService.create(new Account("Raj", new BigDecimal(1000)));
//		accountService.create(new Account("Ekta", new BigDecimal(1000)));

		List<Account> accounts = accountService.findAll();
		accounts.forEach(System.out::println);

		accountService.transfer(1, 2, new BigDecimal(10));
	}

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

}
