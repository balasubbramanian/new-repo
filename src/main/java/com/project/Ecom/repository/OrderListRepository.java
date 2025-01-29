package com.project.Ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ecom.entity.OrdersList;

@Repository
public interface OrderListRepository extends JpaRepository<OrdersList, Long> {
}
