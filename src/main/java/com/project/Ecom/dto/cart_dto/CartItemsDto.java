package com.project.Ecom.dto.cart_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class CartItemsDto {

    private Long productId;
    private String productName;

    private int quantity;

    private Double price;

}
