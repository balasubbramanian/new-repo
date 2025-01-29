package com.project.Ecom.repository;

import com.project.Ecom.entity.Category;
import com.project.Ecom.entity.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);

    @Query("SELECT '*' FROM `product` where product_name LIKE LOWER(CONCAT('%', :productName, '%'))")
    List<Product> findByProductName(String productName);

}
