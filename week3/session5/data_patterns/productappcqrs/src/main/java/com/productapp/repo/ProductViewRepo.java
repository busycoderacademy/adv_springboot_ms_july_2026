package com.productapp.repo;

import com.productapp.model.Product;
import com.productapp.model.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductViewRepo extends JpaRepository<ProductView,Integer> {
}
