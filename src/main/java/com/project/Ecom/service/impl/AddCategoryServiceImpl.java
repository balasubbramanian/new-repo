package com.project.Ecom.service.impl;

import com.project.Ecom.dto.category_dto.CreateCategoryDTO;
import com.project.Ecom.entity.Category;
import com.project.Ecom.repository.CategoryRepository;
import com.project.Ecom.service.IAddCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AddCategoryServiceImpl implements IAddCategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public String addCatService(CreateCategoryDTO createCategoryDTO) {

        Category category = new Category();

        String categoryName = createCategoryDTO.getCategoryName();
        System.out.println("cate " + categoryName);

        category.setDescription(createCategoryDTO.getDescription());

        //product
        Category newCate = categoryRepository.save(category);

        return "New category added";


    }
}
