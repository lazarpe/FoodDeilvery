package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    /**
     * @return 
     */
    @Override
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public AppUser getAppUserById(String id) {
        return appUserRepository.findById(id).orElse(null);
    }

    /**
     * @param email 
     * @return
     */
    @Override
    public AppUser getAppUserByEmail(String email) {
        return appUserRepository.findAppUserByEmail(email).orElse(null);
    }

    /**
     * @param appUser 
     * @return
     */
    @Override
    public AppUser saveAppUser(AppUser appUser) {
        if (appUserRepository.findAppUserByEmail(appUser.getEmail()).isPresent()) {
            return null;
        }
        return appUserRepository.save(appUser);
    }

    /**
     * @param appUser 
     * @return
     */
    @Override
    public AppUser loginAppUser(AppUser appUser) {
        return null;
    }

    /**
     * @param appUser 
     * @return
     */
    @Override
    public AppUser validateUserLogin(AppUser appUser) {
        return null;
    }

    /**
     * @param appUser 
     * @return
     */
    @Override
    public AppUser editAppUser(AppUser appUser) {
        return null;
    }
}
