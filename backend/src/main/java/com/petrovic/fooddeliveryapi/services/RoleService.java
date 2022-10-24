package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role findRoleById(String id);
    Role findRoleByName(String roleName);
    Role saveRole(Role role);
    Role editRole(Role role);
}
