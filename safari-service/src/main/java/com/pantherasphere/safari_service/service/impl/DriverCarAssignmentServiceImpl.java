package com.pantherasphere.safari_service.service.impl;

import com.pantherasphere.safari_service.entity.DriverCarAssignment;
import com.pantherasphere.safari_service.repository.DriverCarAssignmentRepository;
import com.pantherasphere.safari_service.service.DriverCarAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverCarAssignmentServiceImpl implements DriverCarAssignmentService {

    private final DriverCarAssignmentRepository repo;

    @Override
    public DriverCarAssignment assignDriverCar(DriverCarAssignment assignment) {
        return repo.save(assignment);
    }

    @Override
    public List<DriverCarAssignment> getAllAssignments() {
        return repo.findAll();
    }
}
