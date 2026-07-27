package com.bankapp;

import com.bankapp.dto.AccountDto;
import com.bankapp.dto.BankDtoConfig;
import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(BankDtoConfig.class)
//		(exclude = {DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BankappApplication implements  CommandLineRunner {

	@Autowired
	private AccountService accountService;

	@Override
	public void run(String... args) throws Exception {
		accountService.create(new Account("Raj", new BigDecimal(1000), "raj@gmail.com", "9945678900"));
		accountService.create(new Account("Ekta", new BigDecimal(1000), "ekta@gmail.com", "98345678906"));

		List<Account> accounts = accountService.findAll();
		accounts.forEach(System.out::println);

//		accountService.transfer(1, 2, new BigDecimal(10));
	}

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

}
