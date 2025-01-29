package com.project.Ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ecom.entity.OrderRecord;

@Repository
public interface OrderRepository extends JpaRepository<OrderRecord, Long> {
}
