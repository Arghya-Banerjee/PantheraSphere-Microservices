package com.pantherasphere.safari_service.repository;

import com.pantherasphere.safari_service.entity.DriverCarAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DriverCarAssignmentRepository extends JpaRepository<DriverCarAssignment, UUID> {
}