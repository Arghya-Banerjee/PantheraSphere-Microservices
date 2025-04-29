package com.pantherasphere.safari_service.service;

import com.pantherasphere.safari_service.entity.DriverCarAssignment;

import java.util.List;
import java.util.UUID;

public interface DriverCarAssignmentService {
    DriverCarAssignment assignDriverCar(DriverCarAssignment assignment);
    List<DriverCarAssignment> getAllAssignments();
}