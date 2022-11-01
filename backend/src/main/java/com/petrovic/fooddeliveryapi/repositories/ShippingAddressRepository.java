package com.petrovic.fooddeliveryapi.repositories;

import com.petrovic.fooddeliveryapi.models.Role;
import com.petrovic.fooddeliveryapi.models.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, String> {
}
