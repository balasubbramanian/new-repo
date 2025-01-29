package com.project.Ecom.service.impl;

import com.project.Ecom.dto.category_dto.CreateCategoryDTO;
import com.project.Ecom.entity.Category;
import com.project.Ecom.repository.CategoryRepository;
import com.project.Ecom.service.IAddCategoryService;
import org.springframework.stereotype.Service;

@Service
public class AddCategoryServiceImpl implements IAddCategoryService {

    private final CategoryRepository categoryRepository;

    public AddCategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String addCatService(CreateCategoryDTO createCategoryDTO) {

        Category category = new Category();

        category.setCategoryName(createCategoryDTO.getCategoryName());

        category.setDescription(createCategoryDTO.getDescription());

        categoryRepository.save(category);

        return "New category added";

    }
}
