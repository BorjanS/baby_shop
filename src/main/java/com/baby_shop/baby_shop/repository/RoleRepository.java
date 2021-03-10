package com.baby_shop.baby_shop.repository;

import com.baby_shop.baby_shop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String role_user);
}
