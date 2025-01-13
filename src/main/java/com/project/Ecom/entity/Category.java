package com.project.Ecom.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    private String categoryName;

    private String description;

    @OneToMany(mappedBy = "category", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Product.class)
    private Set<Product> products;
}
