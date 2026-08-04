package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productapp.dto.Product;

@RestController
public class ProductConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "product-consumer")
    public String getProduct() {
        Product product =
                restTemplate.getForObject("http://productapp:8080/product", Product.class);

        return product.toString();
    }
}
