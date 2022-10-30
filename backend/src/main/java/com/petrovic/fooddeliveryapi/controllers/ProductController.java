package com.petrovic.fooddeliveryapi.controllers;

import com.petrovic.fooddeliveryapi.models.Product;
import com.petrovic.fooddeliveryapi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Product>> getAvailableProducts() {
        return ResponseEntity.ok().body(productService.getAvailableProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.ok().body(productService.getProductById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable String id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}
