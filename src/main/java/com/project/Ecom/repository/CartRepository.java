package com.project.Ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Ecom.entity.CartStatus;
import com.project.Ecom.entity.MyCart;

@Repository
public interface CartRepository extends JpaRepository<MyCart, Long> {

    @Query("SELECT m FROM MyCart m WHERE m.customer.id = :Id and m.cartStatus= :cartStatus")
    Optional<MyCart> findByCustomer_IdAndCartStatus(@Param("Id") Long Id, @Param("cartStatus") CartStatus cartStatus);

}
