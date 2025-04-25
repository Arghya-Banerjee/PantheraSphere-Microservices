package com.pantherasphere.tiger_service.repository;

import com.pantherasphere.tiger_service.entity.TigerMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TigerRepository extends JpaRepository<TigerMaster, UUID> {

    List<TigerMaster> findByResidentForestId(UUID forestId);

    List<TigerMaster> findByGenderIgnoreCase(String gender);

    List<TigerMaster> findByNameContainingIgnoreCase(String name);

    List<TigerMaster> findByAgeBetween(int min, int max);

    List<TigerMaster> findAllByOrderByLastSightedDesc();

}
