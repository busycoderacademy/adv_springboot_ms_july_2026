package com.eureaka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EureakaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EureakaApplication.class, args);
	}

}
