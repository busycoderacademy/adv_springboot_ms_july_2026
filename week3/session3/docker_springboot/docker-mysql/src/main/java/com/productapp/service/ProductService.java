package com.productapp.service;

import com.productapp.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product save(Product product);
}