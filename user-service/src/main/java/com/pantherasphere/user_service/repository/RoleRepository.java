package com.pantherasphere.user_service.repository;

import com.pantherasphere.user_service.entity.RoleMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleMaster, Integer> {

    Optional<RoleMaster> findByRoleName(String roleName);
}
