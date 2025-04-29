package com.pantherasphere.safari_service.controller;

import com.pantherasphere.safari_service.entity.DriverMaster;
import com.pantherasphere.safari_service.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/safari/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<DriverMaster> addDriver(@RequestBody DriverMaster driver) {
        return ResponseEntity.ok(driverService.addDriver(driver));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverMaster> getDriver(@PathVariable UUID id) {
        return ResponseEntity.ok(driverService.getDriver(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DriverMaster>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }
}