package com.tuananhdo.repository;

import com.tuananhdo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByName(String role);
}
