package com.petrovic.fooddeliveryapi.models;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUser {
        @Id
        private String id;
        private String name;
        public String email;
        private String password;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinColumn(name = "role_id")
        private Collection<Role> roles = new ArrayList<>();

        @PrePersist
        public void prePersist() {
            if (id == null) {
                id = UUID.randomUUID().toString();
            }
            // encrypt password
            if (password != null)
                password = BCrypt.hashpw(password, BCrypt.gensalt());
        }
}