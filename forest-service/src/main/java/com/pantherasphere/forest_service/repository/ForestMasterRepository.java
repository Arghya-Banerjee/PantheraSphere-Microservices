package com.pantherasphere.forest_service.repository;

import com.pantherasphere.forest_service.entity.ForestMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ForestMasterRepository extends JpaRepository<ForestMaster, UUID> {

    List<ForestMaster> findByForestType_ForestTypeId(UUID typeId);
    List<ForestMaster> findByStateIgnoreCase(String state);
    List<ForestMaster> findByForestNameContainingIgnoreCase(String name);

}
