package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.exceptions.LoginException;
import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.models.Role;
import com.petrovic.fooddeliveryapi.repositories.AppUserRepository;
import com.petrovic.fooddeliveryapi.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository, RoleRepository roleRepository) {
        this.appUserRepository = appUserRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<AppUser> getAllAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getAppUserById(String id) {
        return appUserRepository.findById(id).orElse(null);
    }

    @Override
    public AppUser getAppUserByEmail(String email) {
        return appUserRepository.findAppUserByEmail(email);
    }

    @Override
    public AppUser saveAppUser(AppUser appUser) throws LoginException {
        if (!(appUserRepository.findAppUserByEmail(appUser.getEmail()) == null)) {
            throw new LoginException(HttpStatus.CONFLICT, "User with email " + appUser.getEmail() + " already exists. Please log in!");
        }
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser loginAppUser(AppUser appUser) throws LoginException {
        AppUser dbUser;
        if (appUser.getId() == null) {
            dbUser = appUserRepository.findAppUserByEmail(appUser.getEmail());
        } else {
            dbUser = appUserRepository.findById(appUser.getId()).orElse(null);
        }

        if (dbUser == null) {
            throw new LoginException(HttpStatus.NOT_FOUND, "User with email " + appUser.getEmail() + " does not exist. Please register!");
        }
        if (!BCrypt.checkpw(appUser.getPassword(), dbUser.getPassword())) {
            throw new LoginException(HttpStatus.UNAUTHORIZED, "Incorrect password!");
        }
        return dbUser;
    }

    @Override
    public AppUser editAppUser(AppUser appUser) {
        return null;
    }

    /**
     * @param role 
     * @return
     */
    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * @param appUserEmail
     * @param roleName
     */
    @Override
    public void addRoleToUser(String appUserEmail, String roleName) {
        AppUser appUser = appUserRepository.findAppUserByEmail(appUserEmail);
        Role role = roleRepository.findByName(roleName);
        appUser.getRoles().add(role);
    }
}
