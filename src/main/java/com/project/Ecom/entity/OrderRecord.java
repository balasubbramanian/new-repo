package com.project.Ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    private Date orderDate;

    private String orderNumber;  // Need to generate order number at runtime which can be displayed to user.

    private int orderTotal;

  //  private int orderItems;

    @ManyToOne(optional = false, targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "orderRecord", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = OrdersList.class)
    private List<OrdersList> ordersLists;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL,optional = false, targetEntity = Payment.class)
    @JoinColumn(name="Payment_Id", referencedColumnName = "paymentId", nullable = false)
    private Payment payment;

}
