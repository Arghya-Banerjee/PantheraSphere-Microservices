package com.pantherasphere.safari_service.controller;

import com.pantherasphere.safari_service.entity.DriverCarAssignment;
import com.pantherasphere.safari_service.service.DriverCarAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/safari/assignment")
@RequiredArgsConstructor
public class DriverCarAssignmentController {

    private final DriverCarAssignmentService assignmentService;

    @PostMapping("/assign")
    public ResponseEntity<DriverCarAssignment> assignDriverCar(@RequestBody DriverCarAssignment assignment) {
        return ResponseEntity.ok(assignmentService.assignDriverCar(assignment));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DriverCarAssignment>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }
}