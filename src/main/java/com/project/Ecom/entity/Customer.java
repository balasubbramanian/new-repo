package com.project.Ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    private String customerName;

    private String emailId;

    private String phoneNo;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = DeliveryAddress.class)
    private List<DeliveryAddress> deliveryAddress;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = MyCart.class)
    private List<MyCart> myCarts;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = OrderRecord.class)
    private List<OrderRecord> orderRecords;
}
