package com.project.Ecom.controller;


import com.project.Ecom.dto.category_dto.CreateCategoryDTO;
import com.project.Ecom.service.IAddCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AddCategoryController {

    private IAddCategoryService iAddCategoryService;


    @PostMapping("add/cat")
     public ResponseEntity<String> addCategory(@RequestBody CreateCategoryDTO createCategoryDTO) {

         String message = iAddCategoryService.addCatService(createCategoryDTO);
         return ResponseEntity.status(HttpStatus.CREATED).body(message);


     }







}
