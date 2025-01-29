package com.project.Ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Ecom.entity.DeliveryAddress;

@Repository
public interface AddressRepository extends JpaRepository<DeliveryAddress, Long> {
}
