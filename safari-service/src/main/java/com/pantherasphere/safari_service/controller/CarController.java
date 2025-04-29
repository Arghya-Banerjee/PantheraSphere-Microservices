package com.pantherasphere.safari_service.controller;

import com.pantherasphere.safari_service.entity.CarMaster;
import com.pantherasphere.safari_service.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/safari/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/add")
    public ResponseEntity<CarMaster> addCar(@RequestBody CarMaster car) {
        return ResponseEntity.ok(carService.addCar(car));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarMaster> getCar(@PathVariable UUID id) {
        return ResponseEntity.ok(carService.getCar(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarMaster>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }
}