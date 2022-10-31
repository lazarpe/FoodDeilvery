package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.CartItem;
import com.petrovic.fooddeliveryapi.repositories.CartItemRepository;
import com.petrovic.fooddeliveryapi.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public CartItem getCartItemById(String id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public float getCartItemTotalPrice(CartItem cartItem) {
        return cartItem.getPrice() * cartItem.getQuantity();
    }

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        cartItem.setPrice(cartItem.getProduct().getPrice());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteCartItemById(String id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public void updateCartItem(CartItem cartItem, String id) {
        try {
            CartItem cartItemToUpdate = getCartItemById(id);
            cartItemToUpdate.setQuantity(cartItem.getQuantity());
            cartItemToUpdate.setProduct(cartItem.getProduct());
            cartItemToUpdate.setPrice(getCartItemTotalPrice(cartItem));
            saveCartItem(cartItemToUpdate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
