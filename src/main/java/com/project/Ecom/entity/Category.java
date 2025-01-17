package com.project.Ecom.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    private String categoryName;

    private String description;

    @OneToMany(mappedBy = "category", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Product.class)
    private Set<Product> products;


}
