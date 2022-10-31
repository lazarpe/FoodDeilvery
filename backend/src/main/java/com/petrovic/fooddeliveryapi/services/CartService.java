package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.Customer;
import com.petrovic.fooddeliveryapi.models.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    ShoppingCart getCartById(String id);
    List<ShoppingCart> getAllCarts();
    List<ShoppingCart> findShoppingCartsByUser(Optional<Customer> customer);
    float getCartTotalPrice(ShoppingCart cart);
    ShoppingCart saveCart(ShoppingCart cart);
    void deleteCartById(String id);
}
