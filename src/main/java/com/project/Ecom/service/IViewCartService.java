package com.project.Ecom.service;

import com.project.Ecom.dto.cart_dto.ViewCartDto;

public interface IViewCartService {

    public ViewCartDto viewMyCart(Long custId);

}
