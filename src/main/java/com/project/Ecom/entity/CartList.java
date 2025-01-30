package com.project.Ecom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CartList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartListId;

    @ManyToOne(optional = false, targetEntity = Product.class)
    @JoinColumn(name = "product_id", referencedColumnName = "productId", nullable = false)
    private Product product;

    private int quantity;

    private Double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "myCart_Id", referencedColumnName = "cartId", nullable = false)
    private MyCart myCart;

}
