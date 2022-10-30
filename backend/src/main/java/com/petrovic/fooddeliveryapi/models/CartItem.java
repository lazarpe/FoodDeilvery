package com.petrovic.fooddeliveryapi.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;

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
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    private ShoppingCart shoppingCart;
}
