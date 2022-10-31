package com.petrovic.fooddeliveryapi.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity(name = "customers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;
    @OneToMany(mappedBy = "customer")
    private Set<ShoppingCart> shoppingCarts;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
