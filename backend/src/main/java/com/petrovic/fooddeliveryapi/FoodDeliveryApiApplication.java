package com.petrovic.fooddeliveryapi;

import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.models.Product;
import com.petrovic.fooddeliveryapi.models.Role;
import com.petrovic.fooddeliveryapi.services.AppUserService;
import com.petrovic.fooddeliveryapi.services.ProductService;
import com.petrovic.fooddeliveryapi.services.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class FoodDeliveryApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodDeliveryApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleService roleService, AppUserService appUserService, ProductService productService) {
        return args -> {
            final String role_user = "ROLE_USER";
            if (roleService.findRoleByName(role_user) == null) {
                roleService.saveRole(new Role(null, "ROLE_USER"));
                roleService.saveRole(new Role(null, "ROLE_ADMIN"));

                appUserService.saveAppUser(new AppUser(
                        null, "admin", "admin@mail.com", "adminpw", new ArrayList<>(), null));

                appUserService.addRoleToUser("admin@mail.com", "ROLE_ADMIN");
            }

            if (productService.getAllProducts().isEmpty()) {


            productService.saveProduct(new Product(
                    null,
                    "Pizza",
                    "Very delicious Italian pizza made by Giovanni.",
                    "https://images.unsplash.com/photo-1544982503-9f984c14501a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=987&q=80",
                    5.99f,
                    true));

            productService.saveProduct(new Product(
                    null,
                    "Burger",
                    "Very delicious American burger made by John.",
                    "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1899&q=80",
                    4.99f,
                    true));

            productService.saveProduct(new Product(
                    null,
                    "Sushi",
                    "Very delicious Japanese sushi made by Toshi.",
                    "https://images.unsplash.com/photo-1563612116625-3012372fccce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1341&q=80",
                    6.99f,
                    true));

            productService.saveProduct(new Product(
                    null,
                    "Coca Cola",
                    "Refreshing drink after a delicious meal.",
                    "https://images.unsplash.com/photo-1624552184280-9e9631bbeee9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1887&q=80",
                    1.99f,
                    true));
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
