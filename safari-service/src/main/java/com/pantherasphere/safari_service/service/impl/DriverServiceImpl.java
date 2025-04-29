package com.pantherasphere.safari_service.service.impl;

import com.pantherasphere.safari_service.entity.DriverMaster;
import com.pantherasphere.safari_service.repository.DriverMasterRepository;
import com.pantherasphere.safari_service.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverMasterRepository repo;

    @Override
    public DriverMaster addDriver(DriverMaster driver) {
        return repo.save(driver);
    }

    @Override
    public DriverMaster getDriver(UUID driverId) {
        return repo.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    @Override
    public List<DriverMaster> getAllDrivers() {
        return repo.findAll();
    }
}
