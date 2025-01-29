package com.project.Ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;

    private String address1;

    private int pinCode;

    @ManyToOne(optional = false, targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

}
