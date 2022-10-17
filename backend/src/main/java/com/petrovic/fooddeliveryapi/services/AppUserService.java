package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.AppUser;

import java.util.List;

public interface AppUserService {
    List<AppUser> getAllAppUsers();

    AppUser getAppUserById(String id);

    AppUser getAppUserByEmail(String email);

    AppUser saveAppUser(AppUser appUser);

    AppUser loginAppUser(AppUser appUser);

    AppUser validateUserLogin(AppUser appUser);

    AppUser editAppUser(AppUser appUser);
}
