package com.petrovic.fooddeliveryapi.repositories;

import com.petrovic.fooddeliveryapi.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String> {
}
