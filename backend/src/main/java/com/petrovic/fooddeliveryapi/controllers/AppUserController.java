package com.petrovic.fooddeliveryapi.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petrovic.fooddeliveryapi.exceptions.LoginException;
import com.petrovic.fooddeliveryapi.models.AppUser;
import com.petrovic.fooddeliveryapi.models.Role;
import com.petrovic.fooddeliveryapi.services.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

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

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                AppUser appUser = appUserService.getAppUserByName(username);

                String access_token = JWT.create()
                        .withSubject(appUser.getName())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", appUser.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
             } catch (Exception e) {
                response.setHeader("error", e.getMessage());
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), error);

            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

    }

    /*@CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<AppUser> loginUser(@RequestBody AppUser appUser) throws LoginException {
        System.out.println("Got login request with payload of " + appUser.toString());
        return ResponseEntity.ok().body(appUserService.loginAppUser(appUser));
    }*/

@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}