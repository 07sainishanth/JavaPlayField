package com.trailmvc.webserverplayfield.repository;

import com.trailmvc.webserverplayfield.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
