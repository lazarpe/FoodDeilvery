package com.petrovic.fooddeliveryapi.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

@Entity(name = "shopping_carts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShoppingCart {
    @Id
    private String id;
    private float total_price;
    private Date order_date;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "shipping_address_id", nullable = false)
    private ShippingAddress shippingAddress;

    @OneToMany(mappedBy = "shoppingCart")
    private Set<CartItem> cartItems;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
