package com.project.Ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ecom.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
