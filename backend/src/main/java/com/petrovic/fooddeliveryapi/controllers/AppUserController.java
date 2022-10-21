package com.petrovic.fooddeliveryapi.controllers;

import com.petrovic.fooddeliveryapi.exceptions.LoginException;
import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/")
    public List<AppUser> getAllAppUsers() {
        return appUserService.getAllAppUsers();
    }

    @GetMapping("/{id}")
    public AppUser getAppUserById(@PathVariable String id) {
        return appUserService.getAppUserById(id);
    }

    // Get appuser by email
    @GetMapping("/email/{email}")
    public AppUser getAppUserByEmail(@PathVariable String email) {
        return appUserService.getAppUserByEmail(email);
    }

    @CrossOrigin
    @PostMapping("/register")
    public AppUser saveUser(@RequestBody AppUser appUser) throws LoginException {
        System.out.println("Got register request with payload of " + appUser.toString());
        return appUserService.saveAppUser(appUser);
    }
}
