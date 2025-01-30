package com.project.Ecom.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.project.Ecom.dto.items_dto.ResponseItemsDto;
import com.project.Ecom.entity.Category;
import com.project.Ecom.entity.Product;
import com.project.Ecom.mapper.ProductToResponseItemsDto;
import com.project.Ecom.repository.CategoryRepository;
import com.project.Ecom.repository.ProductRepository;
import com.project.Ecom.service.ISearchItemsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SearchItemServiceImpl implements ISearchItemsService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    // 1. name can be a product name 2. name can be a category

    @Override
    public List<ResponseItemsDto> searchItems(String name) {

        Optional<Category> category = categoryRepository.findByCategoryNameContainingIgnoreCase(name);

        if (category.isPresent()) {

            Category cat = category.get();

            // List<Product> products =
            // productRepository.findByCategory_Id(cat.getCategoryId());

            List<Product> products2 = cat.getProducts();
            List<ResponseItemsDto> list = products2.stream()
                    .map(product -> ProductToResponseItemsDto.productToDto(product)).toList();

            return list;

        }

        List<Product> products = productRepository.findByProductName(name);

        List<ResponseItemsDto> list = products.stream().map(product -> ProductToResponseItemsDto.productToDto(product))
                .toList();

        return list; // This will return null if nothing is matched.

    }

}
