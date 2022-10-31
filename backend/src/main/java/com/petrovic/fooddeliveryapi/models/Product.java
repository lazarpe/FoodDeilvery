package com.petrovic.fooddeliveryapi.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "products")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private float price;
    private boolean isAvailable;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }
}
