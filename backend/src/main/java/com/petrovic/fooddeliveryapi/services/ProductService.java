package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getAvailableProducts();
    Product getProductById(String id);
    Product saveProduct(Product product);
    void deleteProductById(String id);
}
