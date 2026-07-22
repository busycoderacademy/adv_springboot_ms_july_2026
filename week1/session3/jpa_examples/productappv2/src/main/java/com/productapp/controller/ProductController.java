package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Product;
import com.productapp.service.ProductService;

@RestController
public class ProductController {
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@GetMapping("products")
	public ResponseEntity<List<Product>> getAll(){
		return ResponseEntity.ok(productService.getAll());
	}
	

	@GetMapping("products/{id}")
	public ResponseEntity<Product> getById(@PathVariable(name = "id") int id){
		return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
	}
	
	@DeleteMapping("products/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "id") int id){
		 productService.deteteProduct(id);
		 return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping("products/{id}")
	public ResponseEntity<Product> updateById(@PathVariable(name = "id") int id,@RequestBody Product product){
		Product updateProduct= productService.updateProduct(id, product);
		return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
	}
	
	@PostMapping("products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
	}
	
	@GetMapping(path = "productsorted")
	public List<Product> getAllProductSorted(@RequestParam(name="field")  String field) {
		return productService.getAllProductSorted(field);
	}

	//productpage?offset=4&pageSize=20
	@GetMapping(path = "productpage")
	public Page<Product> getAllProductPage(@RequestParam(name="offset") int offset,
			@RequestParam(name="pageSize") int pageSize) {
		return productService.getAllProductPage(offset, pageSize);
	}

	//productpagesorted?offset=4&pageSize=20&field=id
	@GetMapping(path = "productpagesorted")
	public Page<Product> getAllProductPageSorted(int offset, int pageSize,String field) {
		return productService.getAllProductPageSorted(field, offset, pageSize);
	}
	
}

















//@RestController
//public class ProductController {
//	
//	private ProductService productService;
//
//	@Autowired
//	public ProductController(ProductService productService) {
//		this.productService = productService;
//	}
//	
//	
//	@GetMapping("products")
//	public List<Product> getAll(){
//		return productService.getAll();
//	}
//	
//
//	@GetMapping("products/{id}")
//	public Product getById(@PathVariable(name = "id") int id){
//		return productService.getById(id);
//	}
//	
//	@DeleteMapping("products/{id}")
//	public Product deleteById(@PathVariable(name = "id") int id){
//		return productService.deteteProduct(id);
//	}
//	
//	@PutMapping("products/{id}")
//	public Product updateById(@PathVariable(name = "id") int id,@RequestBody Product product){
//		return productService.updateProduct(id, product);
//	}
//	
//	@PostMapping("products")
//	public Product addProduct(@RequestBody Product product){
//		return productService.addProduct(product);
//	}
//}












