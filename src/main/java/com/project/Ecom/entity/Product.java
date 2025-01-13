package com.project.Ecom.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String productName;

    private String brandName;

    private Double price;


    @ManyToOne(optional = true)
    @JoinColumn(name = "cat_id", referencedColumnName = "categoryId", nullable = true)
    private Category category;

}
