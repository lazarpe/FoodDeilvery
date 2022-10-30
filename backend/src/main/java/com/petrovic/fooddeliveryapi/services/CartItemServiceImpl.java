package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.CartItem;
import com.petrovic.fooddeliveryapi.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
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
