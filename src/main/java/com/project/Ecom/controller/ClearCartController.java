package com.project.Ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Ecom.service.IClearCartService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("cart")
public class ClearCartController {

    @Autowired
    private IClearCartService clearCartService;

    @DeleteMapping("/clear")
    public ResponseEntity<String> clears(@RequestParam Long custId) {

        String s = clearCartService.clearCart(custId);

        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

}
