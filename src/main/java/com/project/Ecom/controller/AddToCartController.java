package com.project.Ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Ecom.dto.cart_dto.AddProdToCart_Dto;
import com.project.Ecom.service.IAddToCartService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@NoArgsConstructor
@RequestMapping("cart")
public class AddToCartController {

    private IAddToCartService addToCartService;

    @Autowired
    public AddToCartController(IAddToCartService addToCartService) {
        this.addToCartService = addToCartService;
    }

    @PostMapping("/add/product")
    public ResponseEntity<String> addToCart(@RequestBody AddProdToCart_Dto addProdToCart_Dto) {

        String s = addToCartService.addProdToCart(addProdToCart_Dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }

}
