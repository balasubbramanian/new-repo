package com.project.Ecom.mapper;

import com.project.Ecom.dto.items_dto.ResponseItemsDto;
import com.project.Ecom.entity.Product;

public class ProductToResponseItemsDto {

    public static ResponseItemsDto productToDto(Product product) {

        return ResponseItemsDto.builder()
                .catId(product.getCategory().getCategoryId())
                .catName(product.getCategory().getCategoryName())
                .brandName(product.getBrandName())
                .price(product.getPrice())
                .proId(product.getProductId())
                .prodName(product.getProductName())
                .build();

    }

}
