package com.project.Ecom.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrdersList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long OrderListId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Product.class)
    @JoinColumn(name="product_id", referencedColumnName = "productId", nullable = false)
    private Product product;

    private int quantity;

    private int price;

   // private String status;  to denote if status is delivered or not.

    @ManyToOne(optional = false, targetEntity = OrderRecord.class)
    @JoinColumn(name = "order_id", referencedColumnName = "orderId", nullable = false)
    private OrderRecord orderRecord;



}
