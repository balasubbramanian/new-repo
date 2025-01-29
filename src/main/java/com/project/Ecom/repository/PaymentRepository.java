package com.project.Ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ecom.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
