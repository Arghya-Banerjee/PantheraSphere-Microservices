package com.pantherasphere.safari_service.service;

import com.pantherasphere.safari_service.entity.CarMaster;

import java.util.List;
import java.util.UUID;

public interface CarService {
    CarMaster addCar(CarMaster car);
    CarMaster getCar(UUID carId);
    List<CarMaster> getAllCars();
}