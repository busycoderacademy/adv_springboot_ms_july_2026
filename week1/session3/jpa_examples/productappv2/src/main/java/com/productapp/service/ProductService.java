package com.productapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.productapp.dto.Product;

public interface ProductService {
	public List<Product> getAll();
	public Product getById(int id);
	public Product addProduct(Product product);
	public Product deteteProduct(int id);
	public Product updateProduct(int id,Product product);
	
	public List<Product> getAllProductSorted(String field);
	public Page<Product> getAllProductPage(int offset, int pageSize);
	public Page<Product> getAllProductPageSorted(String field,int offset, int pageSize);
	
}
