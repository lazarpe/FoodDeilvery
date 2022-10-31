package com.petrovic.fooddeliveryapi.repositories;

import com.petrovic.fooddeliveryapi.models.Customer;
import com.petrovic.fooddeliveryapi.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, String> {
    @Query("SELECT c FROM shopping_carts c WHERE c.customer = ?1")
    List<ShoppingCart> findShoppingCartsByUser(Optional<Customer> customer);
}
