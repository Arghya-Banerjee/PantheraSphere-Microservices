package com.pantherasphere.safari_service.service.impl;

import com.pantherasphere.safari_service.entity.CarMaster;
import com.pantherasphere.safari_service.repository.CarMasterRepository;
import com.pantherasphere.safari_service.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarMasterRepository repo;

    @Override
    public CarMaster addCar(CarMaster car) {
        return repo.save(car);
    }

    @Override
    public CarMaster getCar(UUID carId) {
        return repo.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    public List<CarMaster> getAllCars() {
        return repo.findAll();
    }
}
