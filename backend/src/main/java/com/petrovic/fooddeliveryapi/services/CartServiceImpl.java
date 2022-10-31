package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.Customer;
import com.petrovic.fooddeliveryapi.models.ShoppingCart;
import com.petrovic.fooddeliveryapi.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    private final CartItemService cartItemService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartItemService cartItemService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
    }

    @Override
    public ShoppingCart getCartById(String id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public List<ShoppingCart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public List<ShoppingCart> findShoppingCartsByUser(Optional<Customer> customer) {
        return cartRepository.findShoppingCartsByUser(customer);
    }

    @Override
    public float getCartTotalPrice(ShoppingCart cart) {
        return cart.getCartItems().stream().map(cartItemService::getCartItemTotalPrice).reduce(0f, Float::sum);
    }

    @Override
    public ShoppingCart saveCart(ShoppingCart cart) {
        cart.setOrder_date(Date.valueOf(LocalDate.now()));
        cart.setTotal_price(getCartTotalPrice(cart));
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCartById(String id) {
        cartRepository.deleteById(id);
    }
}
