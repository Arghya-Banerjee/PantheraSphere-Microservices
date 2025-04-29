package com.pantherasphere.safari_service.repository;

import com.pantherasphere.safari_service.entity.GuideMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuideMasterRepository extends JpaRepository<GuideMaster, UUID> {
}