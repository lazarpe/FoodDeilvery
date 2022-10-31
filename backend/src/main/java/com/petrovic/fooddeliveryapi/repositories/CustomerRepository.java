package com.petrovic.fooddeliveryapi.repositories;

import com.petrovic.fooddeliveryapi.models.Customer;
import com.petrovic.fooddeliveryapi.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
