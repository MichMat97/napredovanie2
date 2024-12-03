package com.vaii.napredovanie2.repository;

import com.vaii.napredovanie2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}