package com.nagarro.communityapplication.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.communityapplication.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Boolean existsByProductcode(String productcode);
    Boolean existsByProductname(String productname);
    Boolean existsByBrand(String brand);
    Product findByProductcode(String productcode);
    List<Product> findByProductname(String productname);
    List<Product> findByBrand(String brand);
}                  
