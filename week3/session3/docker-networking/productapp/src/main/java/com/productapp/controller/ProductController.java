package com.productapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Product;

@RestController
public class ProductController {

    @GetMapping(path = "product")
    public Product getProduct() {
        return new Product(101, "Laptop", 55000);
    }
}