package com.pantherasphere.user_service.repository;

import com.pantherasphere.user_service.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserMaster, UUID> {

    Optional<UserMaster> findByEmail(String email);

    Optional<UserMaster> findByPhoneNumber(String phoneNumber);

    Optional<UserMaster> findByEmailOrPhoneNumber(String email, String phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}
