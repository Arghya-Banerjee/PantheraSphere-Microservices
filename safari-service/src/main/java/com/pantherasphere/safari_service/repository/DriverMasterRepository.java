package com.pantherasphere.safari_service.repository;

import com.pantherasphere.safari_service.entity.DriverMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DriverMasterRepository extends JpaRepository<DriverMaster, UUID> {
}