package com.project.Ecom.dto.category_dto;


import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateCategoryDTO {

    private String categoryName;

    private String description;

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
