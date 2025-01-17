package com.project.Ecom.controller;


import com.project.Ecom.dto.product_dto.AddProductDTO;
import com.project.Ecom.service.IAddProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("add")
public class AddProductController {

    private final IAddProductService addProductService;

    @PostMapping("/pro")
    public ResponseEntity<String> addPro(@RequestBody AddProductDTO addProductDTO) {
        String s = addProductService.addProd(addProductDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }
}
