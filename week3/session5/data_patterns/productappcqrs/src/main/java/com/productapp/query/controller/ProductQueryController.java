package com.productapp.query.controller;

import com.productapp.model.Product;
import com.productapp.model.ProductView;
import com.productapp.repo.ProductViewRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductQueryController {
    private final ProductViewRepo productViewRepo;

    //Get mapping
    @GetMapping
    public List<ProductView> getAllProducts(){
        return productViewRepo.findAll();
    }

    @GetMapping("/{id}")
    public ProductView getProductById(@PathVariable int id){
        return productViewRepo.findById(id).orElse(null);
    }
}
