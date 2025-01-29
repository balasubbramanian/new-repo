package com.project.Ecom.dto.items_dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseItemsDto {

    private Long catId;
    private Long proId;

    private String catName;
    private String prodName;
    private String brandName;
    private Double price;

}
