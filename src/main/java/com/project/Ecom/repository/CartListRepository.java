package com.project.Ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ecom.entity.CartList;

@Repository
public interface CartListRepository extends JpaRepository<CartList, Long> {

}
