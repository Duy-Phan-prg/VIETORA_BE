package com.vietora.modules.auth.repository;

import com.vietora.modules.auth.entity.Role;
import com.vietora.modules.auth.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
