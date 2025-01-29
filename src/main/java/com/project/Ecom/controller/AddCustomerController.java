package com.project.Ecom.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Ecom.dto.customer_dto.CreateCustomerDTO;
import com.project.Ecom.service.IAddCustomerService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class AddCustomerController {

    private final IAddCustomerService addCustomerService;

    public AddCustomerController(IAddCustomerService addCustomerServiceImpl) {
        this.addCustomerService = addCustomerServiceImpl;
    }

    @PostMapping("/add/cust")
    public ResponseEntity<String> addCust(@RequestBody CreateCustomerDTO createCustomerDTO) {
        String s = addCustomerService.addCustomer(createCustomerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }

}
