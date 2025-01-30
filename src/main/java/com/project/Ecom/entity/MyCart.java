package com.project.Ecom.entity;

import java.util.List;

//import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MyCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    private Double orderTotal;

    private int totalItems;

    @Enumerated(EnumType.STRING)
    private CartStatus cartStatus;

    @ManyToOne(optional = false, targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "myCart", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = CartList.class)
    private List<CartList> cartList;

}
