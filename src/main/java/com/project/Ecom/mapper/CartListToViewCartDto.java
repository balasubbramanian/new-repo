package com.project.Ecom.mapper;

import com.project.Ecom.dto.cart_dto.CartItemsDto;

import com.project.Ecom.entity.CartList;

public class CartListToViewCartDto {

    public static CartItemsDto cartItemToDto(CartList cartList) {

        return CartItemsDto.builder()
                .productId(cartList.getProduct().getProductId())
                .productName(cartList.getProduct().getProductName())
                .price(cartList.getPrice())
                .quantity(cartList.getQuantity())
                .build();

    }

}
