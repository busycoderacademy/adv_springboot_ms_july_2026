package com.productapp.repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.productapp.dto.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	@Query("select p from Product p")
	List<Product> getListOfAllProducts();
	
	@Query("select p from Product p where p.name=?1")
	List<Product> getListOfAllProductsBasedOnName(String name);
	
	@Query("select p from Product p where p.name=:name")
	List<Product> getListOfAllProductsBasedOnNameV2(@Param("name")  String name);
	

	@Query("select p from Product p where p.name=?1 and p.price=?2")
	List<Product> getListOfAllProductsBasedOnNameAndPrice(String name, BigDecimal price);
	
	@Query("select p from Product p where p.name=?1 or p.price=?2")
	List<Product> getListOfAllProductsBasedOnNameOrPrice(String name, BigDecimal price);
	
//	
//	List<Product> findByName(String name);
//	
//	List<Product> findByNameContaining(String name);
//	List<Product> findByNameLike(String name);
//	List<Product> findByNameStartingWith(String name);
//	
//	List<Product> findByNameEndingWith(String name);
//	
//	List<Product> findByNameIgnoreCase(String name);
//	
//	
//	List<Product> findByMfgDateAfter(LocalDate date);
//	List<Product> findByMfgDateBefore(LocalDate date);
//	List<Product> findByMfgDateBetween(LocalDate date1, LocalDate date);
	
	
	
	
	
	
	
	
}
