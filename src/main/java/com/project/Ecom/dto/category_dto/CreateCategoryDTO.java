package com.project.Ecom.dto.category_dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateCategoryDTO {

    private String categoryName;

    private String description;

}
