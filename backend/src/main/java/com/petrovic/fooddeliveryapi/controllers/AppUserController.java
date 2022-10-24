package com.petrovic.fooddeliveryapi.controllers;

import com.petrovic.fooddeliveryapi.exceptions.LoginException;
import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AppUserController {
    private final AppUserService appUserService;

    @GetMapping("/")
    public ResponseEntity<List<AppUser>> getAllAppUsers() {
        return ResponseEntity.ok().body(appUserService.getAllAppUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getAppUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(appUserService.getAppUserById(id));
    }

    // Get appuser by email
    @GetMapping("/email/{email}")
    public ResponseEntity<AppUser> getAppUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok().body(appUserService.getAppUserByEmail(email));
    }

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser) throws LoginException {
        System.out.println("Got register request with payload of " + appUser.toString());
        return ResponseEntity.ok().body(appUserService.saveAppUser(appUser));
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<AppUser> loginUser(@RequestBody AppUser appUser) throws LoginException {
        System.out.println("Got login request with payload of " + appUser.toString());
        return ResponseEntity.ok().body(appUserService.loginAppUser(appUser));
    }
}
