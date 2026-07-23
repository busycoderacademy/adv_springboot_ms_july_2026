package com.productapp;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.dto.Product;
import com.productapp.repo.ProductRepo;

@SpringBootApplication
public class Productappv1Application implements CommandLineRunner{
	
	@Autowired
	private ProductRepo productRepo;
	
	public static void main(String[] args) {
	SpringApplication.run(Productappv1Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Random random = new Random();

		List<Product> products =
		        IntStream.rangeClosed(1, 20000)
		                .mapToObj(i -> new Product(
		                        "product " + i,
		                        BigDecimal.valueOf(random.nextDouble(5000))
		                ))
		                .toList();
		
		productRepo.saveAll(products);
	}
}

