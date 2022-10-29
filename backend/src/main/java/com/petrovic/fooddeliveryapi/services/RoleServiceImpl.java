package com.petrovic.fooddeliveryapi.services;

import com.petrovic.fooddeliveryapi.models.Role;
import com.petrovic.fooddeliveryapi.repositories.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleById(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public Role saveRole(Role role) {
        try {
            return roleRepository.save(role);
        } catch (Exception InstanceAlreadyExistsException) {
            InstanceAlreadyExistsException.printStackTrace();
            return null;
        }
    }
}
