package com.project.Ecom.service.impl;

import org.springframework.stereotype.Service;
import com.project.Ecom.dto.cart_dto.RemoveFromCartDto;
import com.project.Ecom.entity.CartList;
import com.project.Ecom.entity.CartStatus;
import com.project.Ecom.entity.MyCart;
import com.project.Ecom.repository.CartRepository;
import com.project.Ecom.service.IRemoveFromCartService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RemoveFromCartServiceImpl implements IRemoveFromCartService {

    private final CartRepository cartRepository;

    @Override
    public String removeCart(RemoveFromCartDto removeFromCartDto) {

        MyCart activeCart = cartRepository
                .findByCustomer_IdAndCartStatus(removeFromCartDto.getCustomerId(), CartStatus.ACTIVE)
                .orElseThrow(() -> new UnsupportedOperationException(
                        "No cart for user :" + removeFromCartDto.getCustomerId()));

        // To find existing product from the cartList

        CartList existingProduct = activeCart.getCartList().stream().filter(item -> item.getProduct().getProductId()
                .equals(removeFromCartDto.getProductId()))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException(
                        "No such Product for :" + removeFromCartDto.getProductId()));

        // int index = activeCart.getCartList().indexOf(existingProduct);

        // Reduce the quantity or remove from CartList
        if (existingProduct.getQuantity() > 1) {

            existingProduct.setQuantity(existingProduct.getQuantity() - 1);

            existingProduct.setPrice(existingProduct.getProduct().getPrice() * existingProduct.getQuantity());

            // activeCart.getCartList().set(index, existingProduct); not required.. coz its
            // object reference.
            // if CartList is immutable, then you would need to replace it in the list.

            // total price

        } else {

            activeCart.getCartList().remove(existingProduct);

        }

        if (activeCart.getCartList().isEmpty()) {

            cartRepository.delete(activeCart);

            return "Product removed from the cart";
        } else {
            double totalSum = activeCart.getCartList().stream()
                    .mapToDouble(CartList::getPrice).sum();
            activeCart.setOrderTotal(totalSum);
            activeCart.setTotalItems(activeCart.getTotalItems() - 1);

            cartRepository.save(activeCart);

            return "Product removed from the cart";

        }

    }
}
