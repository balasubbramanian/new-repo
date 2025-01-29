package com.project.Ecom.dto.product_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProductDTO {

    private String productName;

    private String brandName;

    private Double price;

    private String categoryName;

}
