package com.bankapp;

import com.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;

@SpringBootApplication
public class BankappApplication implements CommandLineRunner {

	@Autowired
	private AccountService accountService;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.getAll().forEach(System.out::println);
		accountService.transfer(3, 2, new BigDecimal(10000));
		accountService.getAll().forEach(System.out::println);
	}
}
