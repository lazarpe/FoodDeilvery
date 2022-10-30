package com.petrovic.fooddeliveryapi.repositories;

import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, String> {
}
