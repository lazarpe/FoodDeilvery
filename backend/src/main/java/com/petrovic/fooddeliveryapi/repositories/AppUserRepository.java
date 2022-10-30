package com.petrovic.fooddeliveryapi.repositories;

import com.petrovic.fooddeliveryapi.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    @Query("SELECT u FROM users u WHERE u.email = ?1")
    AppUser findAppUserByEmail(String email);
    @Query("SELECT u FROM users u WHERE u.name = ?1")
    AppUser findAppUserByName(String name);
}
