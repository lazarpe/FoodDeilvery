package com.petrovic.fooddeliveryapi.controllers;

import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AppUserController {
    AppUserService appUserService;
    public AppUser saveUser(@RequestBody AppUser appUser) {
        System.out.println("Got register request with payload of " + appUser.toString());
        return appUserService.saveAppUser(appUser);
    }
}
