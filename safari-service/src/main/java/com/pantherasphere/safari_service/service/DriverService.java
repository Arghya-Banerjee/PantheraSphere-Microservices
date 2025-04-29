package com.pantherasphere.safari_service.service;

import com.pantherasphere.safari_service.entity.DriverMaster;

import java.util.List;
import java.util.UUID;

public interface DriverService {
    DriverMaster addDriver(DriverMaster driver);
    DriverMaster getDriver(UUID driverId);
    List<DriverMaster> getAllDrivers();
}