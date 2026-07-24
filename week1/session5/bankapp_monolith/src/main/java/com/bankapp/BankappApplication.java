package com.bankapp;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.math.BigDecimal;
import java.util.List;
@EnableAspectJAutoProxy
@SpringBootApplication
//		(exclude = {DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BankappApplication implements  CommandLineRunner {

	@Autowired
	private AccountService accountService;

	@Override
	public void run(String... args) throws Exception {
		accountService.create(new AccountDto("Raj", new BigDecimal(1000)));
		accountService.create(new AccountDto("Ekta", new BigDecimal(1000)));

		List<AccountDto> accounts = accountService.findAll();
		accounts.forEach(System.out::println);

//		accountService.transfer(1, 2, new BigDecimal(10));
	}

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

}
