package com.busycoder.resilency;

import com.busycoder.resilency.dto.InfoDto;
import com.busycoder.resilency.entities.Account;
import com.busycoder.resilency.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties(InfoDto.class)
@EnableFeignClients("com.busycoder.resilency.serviceproxy")
public class AccountsApplication implements CommandLineRunner {

	@Autowired
	private AccountRepo accountRepo;

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepo.save(new Account("raj",1000,"raj@gmail.com", "7088993300"));

		accountRepo.save(new Account("ekta",1000,"ekta@gmail.com", "7988223300"));

	}


}
