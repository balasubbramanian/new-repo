package com.project.Ecom.dto.cart_dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddProdToCart_Dto {

    private Long customerId;

    // private List<CartItemsDto> cartItemsDto;

    private Long productId;

    private int quantity;

}
