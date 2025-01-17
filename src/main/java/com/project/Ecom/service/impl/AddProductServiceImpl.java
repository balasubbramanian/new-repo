package com.project.Ecom.service.impl;

import com.project.Ecom.dto.product_dto.AddProductDTO;
import com.project.Ecom.entity.Product;
import com.project.Ecom.repository.ProductRepository;
import com.project.Ecom.service.IAddProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AddProductServiceImpl implements IAddProductService {

    private final ProductRepository productRepository;

    @Override
    public String addProd(AddProductDTO addProductDTO) {

        Product product = new Product();

        product.setProductName(addProductDTO.getProductName());
        product.setPrice(addProductDTO.getPrice());
        product.setBrandName(addProductDTO.getBrandName());

        productRepository.save(product);

        return "New Product Added ";
    }
}
