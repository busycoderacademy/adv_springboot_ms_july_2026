package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProductappcqrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappcqrsApplication.class, args);
	}

}
