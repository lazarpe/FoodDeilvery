package com.petrovic.fooddeliveryapi;

import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.models.Role;
import com.petrovic.fooddeliveryapi.services.AppUserService;
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
    CommandLineRunner run(RoleService roleService, AppUserService appUserService) {
        return args -> {
            final String role_user = "ROLE_USER";
            if (roleService.findRoleByName(role_user) == null) {
                roleService.saveRole(new Role(null, "ROLE_USER"));
                roleService.saveRole(new Role(null, "ROLE_ADMIN"));

                appUserService.saveAppUser(new AppUser(
                        null, "admin", "admin@mail.com", "adminpw", new ArrayList<>()));

                appUserService.addRoleToUser("admin@mail.com", "ROLE_ADMIN");
                appUserService.addRoleToUser("admin@mail.com", "ROLE_USER");
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
