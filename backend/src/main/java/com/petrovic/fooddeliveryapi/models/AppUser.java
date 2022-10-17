package com.petrovic.fooddeliveryapi.models;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
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
        private String profilePictureUrl;

        @PrePersist
        public void prePersist() {
            if (id == null) {
                id = UUID.randomUUID().toString();
            }
            // encrypt password
            if (password != null)
                password = BCrypt.hashpw(password, BCrypt.gensalt());
/*
        password = passwordEncoder.encode(password);
*/

        }

}
