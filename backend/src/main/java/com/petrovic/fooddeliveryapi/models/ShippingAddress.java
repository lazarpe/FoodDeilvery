package com.petrovic.fooddeliveryapi.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "shipping_addresses")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShippingAddress {
    @Id
    private String id;
    private String address;
    private String city;
    private String zipcode;
    private String country;

    // maybe have to add cascade type
    @OneToMany(mappedBy = "shippingAddress")
    private Set<ShoppingCart> shoppingCart;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
