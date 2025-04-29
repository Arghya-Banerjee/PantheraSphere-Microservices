package com.pantherasphere.safari_service.repository;

import com.pantherasphere.safari_service.entity.CarMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarMasterRepository extends JpaRepository<CarMaster, UUID> {
}