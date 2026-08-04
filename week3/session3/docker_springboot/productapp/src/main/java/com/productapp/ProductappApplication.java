package com.productapp;

import com.productapp.config.DbConfig;
import com.productapp.config.ProductConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({DbConfig.class, ProductConfig.class})
@SpringBootApplication
public class ProductappApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductappApplication.class, args);
    }

}
