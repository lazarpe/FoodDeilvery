package com.petrovic.fooddeliveryapi.repositories;

import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM products p WHERE p.name = ?1")
    Product findProductByName(String name);

    @Query("SELECT p FROM products p WHERE p.isAvailable = true")
    List<Product> findAvailableProducts();
}
