package com.project.Ecom.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.Ecom.dto.cart_dto.AddProdToCart_Dto;
import com.project.Ecom.entity.CartList;
import com.project.Ecom.entity.Customer;
import com.project.Ecom.entity.MyCart;
import com.project.Ecom.entity.Product;
import com.project.Ecom.repository.CartListRepository;
import com.project.Ecom.repository.CartRepository;
import com.project.Ecom.repository.CustomerRepository;
import com.project.Ecom.repository.ProductRepository;
import com.project.Ecom.service.IAddToCartService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddToCartServiceImpl implements IAddToCartService {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private CartRepository cartRepository;
    private CartListRepository cartListRepository;

    @Override
    public String addProdToCart(AddProdToCart_Dto addProdToCart_Dto) {

    // To check in MyCart Repo if the recieved cust id from Dto is already availabe in "Active" state or not    
    Optional<MyCart> cart = cartRepository.findByCustomer_IdAndCartStatus(addProdToCart_Dto.getCustomerId(), "ACTIVE");

    if(cart.isPresent())
    {
        MyCart activeCart= cart.get();
        CartList cartList = new CartList();
        Optional<Product> product = productRepository.findById(addProdToCart_Dto.getProductId());

        if(product.isPresent()){

            Product prod = product.get();

            double newPrice = prod.getPrice() * addProdToCart_Dto.getQuantity();

            cartList.setPrice(newPrice);
            cartList.setProduct(prod);
            cartList.setQuantity(addProdToCart_Dto.getQuantity());
            cartList.setMyCart(activeCart);
            activeCart.setCartList(List.of(cartList));

            cartListRepository.save(cartList);

           // MyCart updatedCart = new MyCart(0, 0, 0, null, null, null);

            List<CartList> cartLists = activeCart.getCartList();


        }



        cartListRepository.
    }
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProdToCart'");
    }

}
