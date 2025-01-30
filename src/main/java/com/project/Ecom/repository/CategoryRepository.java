package com.project.Ecom.repository;

import com.project.Ecom.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  // @Query("SELECT c FROM Category c WHERE LOWER(c.categoryName) LIKE
  // LOWER(CONCAT('%', :categoryName, '%'))")
  Optional<Category> findByCategoryNameContainingIgnoreCase(String categoryName);

}
