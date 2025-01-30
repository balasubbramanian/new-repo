package com.project.Ecom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Ecom.dto.cart_dto.CartItemsDto;
import com.project.Ecom.dto.cart_dto.ViewCartDto;
import com.project.Ecom.entity.CartStatus;
import com.project.Ecom.entity.MyCart;
import com.project.Ecom.mapper.CartListToViewCartDto;
import com.project.Ecom.repository.CartRepository;
import com.project.Ecom.service.IViewCartService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ViewCartServiceImpl implements IViewCartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public ViewCartDto viewMyCart(Long custId) {

        MyCart activeCart = cartRepository.findByCustomer_IdAndCartStatus(custId, CartStatus.ACTIVE)
                .orElseThrow(() -> new UnsupportedOperationException("No cart for user :" + custId));

        ViewCartDto viewCartDto = new ViewCartDto();

        viewCartDto.setCustomerId(custId);
        viewCartDto.setOrderTotal(activeCart.getOrderTotal());
        viewCartDto.setTotalItems(activeCart.getTotalItems());
        // viewCartDto.setCartList(activeCart.getCartList());

        List<CartItemsDto> list = activeCart.getCartList().stream()
                .map(cartitems -> CartListToViewCartDto.cartItemToDto(cartitems))
                .toList();

        viewCartDto.setCartList(list);

        return viewCartDto;

        // throw new UnsupportedOperationException("Unimplemented method 'viewMyCart'");
    }

}
