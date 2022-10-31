package com.petrovic.fooddeliveryapi.controllers;

import com.petrovic.fooddeliveryapi.models.ShoppingCart;
import com.petrovic.fooddeliveryapi.repositories.CustomerRepository;
import com.petrovic.fooddeliveryapi.services.CartService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;
    private final CustomerRepository customerRepository;

    @GetMapping("/")
    public ResponseEntity<List<ShoppingCart>> getAllCarts() {
        return ResponseEntity.ok().body(cartService.getAllCarts());
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<List<ShoppingCart>> getAllCartsByUserId(@PathVariable String customer_id) {
        return ResponseEntity.ok().body(cartService.findShoppingCartsByUser(customerRepository.findById(customer_id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getCartById(@PathVariable String id) {
        return ResponseEntity.ok().body(cartService.getCartById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<ShoppingCart> saveCart(@RequestBody ShoppingCart cart) {
        return ResponseEntity.ok().body(cartService.saveCart(cart));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCart(@RequestBody ShoppingCart cart) {
        cartService.deleteCartById(cart.getId());
        return ResponseEntity.ok().build();
    }
}
