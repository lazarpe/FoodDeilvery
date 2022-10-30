package com.petrovic.fooddeliveryapi.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

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

    @OneToMany(mappedBy = "shippingAddress")
    private Set<ShoppingCart> shoppingCart;
}
