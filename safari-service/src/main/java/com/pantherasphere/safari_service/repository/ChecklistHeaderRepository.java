package com.pantherasphere.safari_service.repository;

import com.pantherasphere.safari_service.entity.ChecklistHeader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChecklistHeaderRepository extends JpaRepository<ChecklistHeader, UUID> {
}
