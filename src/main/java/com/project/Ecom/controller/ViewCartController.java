package com.project.Ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Ecom.dto.cart_dto.ViewCartDto;
import com.project.Ecom.service.IViewCartService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("cart")
@NoArgsConstructor
@AllArgsConstructor
public class ViewCartController {

    @Autowired
    private IViewCartService viewCartService;

    @GetMapping("/view")
    public ResponseEntity<ViewCartDto> viewCart(@RequestParam Long custId) {

        ViewCartDto viewCartDto = viewCartService.viewMyCart(custId);

        return ResponseEntity.status(HttpStatus.OK).body(viewCartDto);
    }

}
