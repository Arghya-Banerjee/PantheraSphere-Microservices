package com.pantherasphere.forest_service.repository;

import com.pantherasphere.forest_service.entity.ForestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ForestTypeRepository extends JpaRepository<ForestType, UUID> {

}
