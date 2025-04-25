package com.pantherasphere.tiger_service.service.impl;

import com.pantherasphere.tiger_service.dto.CreateTigerDTO;
import com.pantherasphere.tiger_service.dto.UpdateLastSightedDTO;
import com.pantherasphere.tiger_service.entity.TigerMaster;
import com.pantherasphere.tiger_service.repository.TigerRepository;
import com.pantherasphere.tiger_service.service.TigerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TigerServiceImpl implements TigerService {

    @Autowired
    private TigerRepository tigerRepository;

    @Override
    public List<TigerMaster> getAllTigers() {
        return tigerRepository.findAll();
    }

    @Override
    public TigerMaster getTigerById(UUID tigerId) {
        return tigerRepository.findById(tigerId)
                .orElseThrow(() -> new EntityNotFoundException("Tiger with Id: " + tigerId + " not found!"));
    }

    @Override
    public List<TigerMaster> getTigersByForest(UUID forestId) {
        return tigerRepository.findByResidentForestId(forestId);
    }

    @Override
    public List<TigerMaster> getTigersByGender(String gender) {
        return tigerRepository.findByGenderIgnoreCase(gender);
    }

    @Override
    public List<TigerMaster> searchTigersByName(String name) {
        return tigerRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<TigerMaster> getTigersByAgeRange(int min, int max) {
        return tigerRepository.findByAgeBetween(min, max);
    }

    @Override
    public List<TigerMaster> getRecentlySightedTigers() {
        return tigerRepository.findAllByOrderByLastSightedDesc();
    }

    @Override
    public TigerMaster createTiger(CreateTigerDTO dto) {
        TigerMaster tiger = new TigerMaster();
        tiger.setName(dto.getName());
        tiger.setGender(dto.getGender());
        tiger.setAge(dto.getAge());
        tiger.setResidentForestId(dto.getResidentForestId());
        tiger.setAddedDate(LocalDateTime.now());
        tiger.setAddedBy(UUID.randomUUID()); // To be replaced with actual ADMIN ID from Auth
        return tigerRepository.save(tiger);
    }

    @Override
    public TigerMaster updateTiger(UUID tigerId, CreateTigerDTO dto) {
        TigerMaster tiger = getTigerById(tigerId);
        tiger.setName(dto.getName());
        tiger.setGender(dto.getGender());
        tiger.setAge(dto.getAge());
        tiger.setResidentForestId(dto.getResidentForestId());
        return tigerRepository.save(tiger);
    }

    @Override
    public TigerMaster updateLastSighted(UUID tigerId, UpdateLastSightedDTO dto) {
        TigerMaster tiger = getTigerById(tigerId);
        tiger.setLastSighted(dto.getLastSighted());
        return tigerRepository.save(tiger);
    }

    @Override
    public void deleteTiger(UUID tigerId) {
        tigerRepository.deleteById(tigerId);
    }
}
