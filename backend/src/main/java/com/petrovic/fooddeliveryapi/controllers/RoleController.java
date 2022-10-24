package com.petrovic.fooddeliveryapi.controllers;

import com.petrovic.fooddeliveryapi.models.Role;
import com.petrovic.fooddeliveryapi.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findRoleById(@PathVariable String id) {
        return ResponseEntity.ok().body(roleService.findRoleById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Role> findRoleByName(@PathVariable String name) {
        return ResponseEntity.ok().body(roleService.findRoleByName(name));
    }

    @PostMapping("/new")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        System.out.println("Got create new role request with payload of " + role.toString());
        return ResponseEntity.ok().body(roleService.saveRole(role));
    }
}
