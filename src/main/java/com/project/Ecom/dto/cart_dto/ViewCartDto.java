package com.project.Ecom.dto.cart_dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ViewCartDto {

    private Long customerId;
    private Double orderTotal;
    private int totalItems;

    private List<CartItemsDto> cartList;

}
