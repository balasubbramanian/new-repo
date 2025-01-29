package com.project.Ecom.service.impl;

import com.project.Ecom.dto.product_dto.AddProductDTO;
import com.project.Ecom.entity.Category;
import com.project.Ecom.entity.Product;
import com.project.Ecom.repository.CategoryRepository;
import com.project.Ecom.repository.ProductRepository;
import com.project.Ecom.service.IAddProductService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddProductServiceImpl implements IAddProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public String addProd(AddProductDTO addProductDTO) {

        Product product = new Product();

        String catName = addProductDTO.getCategoryName();

        Optional<Category> cat = categoryRepository.findByCategoryName(catName);

        if (cat.isPresent()) {
            Category category = cat.get();

            product.setProductName(addProductDTO.getProductName());
            product.setPrice(addProductDTO.getPrice());
            product.setBrandName(addProductDTO.getBrandName());
            product.setCategory(category);
            category.setProducts(Set.of(product));
            categoryRepository.save(category);
        } else {
            Category category = new Category();
            category.setCategoryName(catName);
            category.setDescription("All the " + catName + "categories");

            product.setProductName(addProductDTO.getProductName());
            product.setPrice(addProductDTO.getPrice());
            product.setBrandName(addProductDTO.getBrandName());
            product.setCategory(category);
            category.setProducts(Set.of(product));
            categoryRepository.save(category);

        }
        return "New Product Added ";
    }
}
