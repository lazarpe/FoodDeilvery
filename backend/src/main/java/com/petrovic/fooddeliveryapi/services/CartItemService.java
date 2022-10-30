package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.CartItem;

public interface CartItemService {
    CartItem getCartItemById(String id);
    float getCartItemTotalPrice(CartItem cartItem);
    CartItem saveCartItem(CartItem cartItem);
    void deleteCartItemById(String id);
    void updateCartItem(CartItem cartItem, String id);
}
