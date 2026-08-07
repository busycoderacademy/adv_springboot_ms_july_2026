package com.productapp.command.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.productapp.command.commands.CreateProductCommand;
import com.productapp.command.handler.ProductCommandHandler;
import com.productapp.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductCommandController {
    private final ProductCommandHandler productCommandHandler;

    @PostMapping
    public Product createProduct(@RequestBody CreateProductCommand createProductCommand){
        try {
            return productCommandHandler.createProduct(createProductCommand);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
