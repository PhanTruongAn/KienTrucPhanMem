package com.example.kttk_week05.repository;

import com.example.kttk_week05.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String roleName);
}
