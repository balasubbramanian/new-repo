package com.project.Ecom.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.Ecom.dto.items_dto.ResponseItemsDto;
import com.project.Ecom.service.ISearchItemsService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@AllArgsConstructor
public class SearchProductController {

    private final ISearchItemsService iSearchItemsService;

    @GetMapping("search/prod")
    public ResponseEntity<List<ResponseItemsDto>> searchItems(@RequestParam String prodName) {

        List<ResponseItemsDto> items = iSearchItemsService.searchItems(prodName);
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

}
