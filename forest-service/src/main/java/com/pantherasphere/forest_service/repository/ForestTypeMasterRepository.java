package com.pantherasphere.forest_service.repository;

import com.pantherasphere.forest_service.entity.ForestTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ForestTypeMasterRepository extends JpaRepository<ForestTypeMaster, UUID> {

}
