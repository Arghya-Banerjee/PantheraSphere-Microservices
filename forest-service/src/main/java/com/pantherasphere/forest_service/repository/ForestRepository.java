package com.pantherasphere.forest_service.repository;

import com.pantherasphere.forest_service.entity.Forest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ForestRepository extends JpaRepository<Forest, UUID> {

    List<Forest> findByForestType_ForestTypeId(UUID typeId);
    List<Forest> findByStateIgnoreCase(String state);
    List<Forest> findByForestNameContainingIgnoreCase(String name);
}
