package com.petrovic.fooddeliveryapi.controllers;

import com.petrovic.fooddeliveryapi.models.CartItem;
import com.petrovic.fooddeliveryapi.services.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart-items")
public class CartItemController {
    private final CartItemService cartItemService;

    @GetMapping("/{id}")
    public void getCartItemById(@PathVariable String id) {
        cartItemService.getCartItemById(id);
    }

    @GetMapping("/{id}/total-price")
    public void getCartItemTotalPrice(@PathVariable String id) {
        cartItemService.getCartItemTotalPrice(cartItemService.getCartItemById(id));
    }

    @DeleteMapping("/{id}/delete")
    public void deleteCartItemById(@PathVariable String id) {
        cartItemService.deleteCartItemById(id);
    }

    @PutMapping("/{id}/update")
    public void updateCartItem(@RequestBody CartItem cartItem, @PathVariable String id) {
        cartItemService.updateCartItem(cartItem, id);
        ResponseEntity.ok().body("CartItem updated successfully");
    }
}
