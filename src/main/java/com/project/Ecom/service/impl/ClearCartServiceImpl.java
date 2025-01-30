package com.project.Ecom.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Ecom.entity.CartStatus;
import com.project.Ecom.entity.MyCart;
import com.project.Ecom.repository.CartRepository;
import com.project.Ecom.service.IClearCartService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClearCartServiceImpl implements IClearCartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public String clearCart(Long custId) {

        MyCart activeCart = cartRepository.findByCustomer_IdAndCartStatus(custId, CartStatus.ACTIVE)
                .orElseThrow(() -> new UnsupportedOperationException("No cart for user :" + custId));

        cartRepository.delete(activeCart);

        return "Cart is cleared";
    }

}
