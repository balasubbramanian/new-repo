package com.project.Ecom.service.impl;

import java.util.ArrayList;
//import java.util.List;
import java.util.Optional;
//import java.util.stream.DoubleStream;

import org.springframework.stereotype.Service;

import com.project.Ecom.dto.cart_dto.AddProdToCart_Dto;
import com.project.Ecom.entity.CartList;
import com.project.Ecom.entity.CartStatus;
import com.project.Ecom.entity.Customer;
import com.project.Ecom.entity.MyCart;
import com.project.Ecom.entity.Product;
//import com.project.Ecom.repository.CartListRepository;
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
    // private CartListRepository cartListRepository;

    @Override
    public String addProdToCart(AddProdToCart_Dto addProdToCart_Dto) {

        // To check in MyCart Repo if the recieved cust id from Dto is already availabe
        // in "Active" state or not
        Optional<MyCart> cart = cartRepository.findByCustomer_IdAndCartStatus(addProdToCart_Dto.getCustomerId(),
                CartStatus.ACTIVE);
        Optional<Product> product = productRepository.findById(addProdToCart_Dto.getProductId());
        Optional<Customer> customer = customerRepository.findById(addProdToCart_Dto.getCustomerId());

        if (cart.isPresent()) {
            MyCart activeCart = cart.get();
            CartList cartList = new CartList();

            if (product.isPresent()) {

                Product prod = product.get();

                double newPrice = prod.getPrice() * addProdToCart_Dto.getQuantity();
                activeCart.setOrderTotal(activeCart.getOrderTotal() + newPrice);
                activeCart.setTotalItems(activeCart.getTotalItems() + 1);
                cartList.setPrice(newPrice);
                cartList.setProduct(prod);
                cartList.setQuantity(addProdToCart_Dto.getQuantity());
                cartList.setMyCart(activeCart);
                // activeCart.setCartList(List.of(cartList)); not a best practice. it will make
                // the list immutable. no operation can be performed.
                activeCart.getCartList().add(cartList);

                cartRepository.save(activeCart);

                // MyCart updatedCart = new MyCart(0, 0, 0, null, null, null);
                // Total amount , total quantity.
                // List<CartList> activeCartLists = activeCart.getCartList();

                // total price
                // double totalSum = activeCartLists.stream().mapToDouble(pro ->
                // pro.getPrice()).sum();

                // total products
                // long countProduct = activeCartLists.stream().count();

                // activeCart.setOrderTotal(totalSum);
                // activeCart.setTotalItems((int) countProduct);

                return "Product is added to the Cart";

            }

            return "No Such Product is Found";
        }

        else {

            if (product.isPresent() & customer.isPresent()) {

                Product prod = product.get();
                Customer cust = customer.get();

                double newPrice = prod.getPrice() * addProdToCart_Dto.getQuantity();

                MyCart newCart = new MyCart();
                CartList newCartList = new CartList();

                newCart.setOrderTotal(newPrice);
                newCart.setTotalItems(1);
                newCart.setCartStatus(CartStatus.ACTIVE);
                newCart.setCustomer(cust);
                newCart.setCartList(new ArrayList<>());

                newCartList.setPrice(newPrice);
                newCartList.setQuantity(addProdToCart_Dto.getQuantity());
                newCartList.setProduct(prod);
                newCartList.setMyCart(newCart);
                newCart.getCartList().add(newCartList);

                cartRepository.save(newCart);

                return "Product is added to the Cart";
            }

            return "No such Product is Found";

        }

    }

}
