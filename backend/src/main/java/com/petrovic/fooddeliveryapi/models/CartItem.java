package com.petrovic.fooddeliveryapi.models;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "cart_items")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItem {
    @Id
    private String id;
    private int quantity;
    private float price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
