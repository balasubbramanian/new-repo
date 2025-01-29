package com.project.Ecom.service;

import java.util.List;

import com.project.Ecom.dto.items_dto.ResponseItemsDto;

public interface ISearchItemsService {

    List<ResponseItemsDto> searchItems(String name);

}