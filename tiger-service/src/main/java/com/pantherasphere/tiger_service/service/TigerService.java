package com.pantherasphere.tiger_service.service;

import com.pantherasphere.tiger_service.dto.CreateTigerDTO;
import com.pantherasphere.tiger_service.dto.UpdateLastSightedDTO;
import com.pantherasphere.tiger_service.entity.TigerMaster;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface TigerService {


    List<TigerMaster> getAllTigers();

    TigerMaster getTigerById(UUID tigerId);

    List<TigerMaster> getTigersByForest(UUID forestId);

    List<TigerMaster> getTigersByGender(String gender);

    List<TigerMaster> searchTigersByName(String name);

    List<TigerMaster> getTigersByAgeRange(int min, int max);

    List<TigerMaster> getRecentlySightedTigers();

    TigerMaster createTiger(CreateTigerDTO dto);

    TigerMaster updateTiger(UUID tigerId, CreateTigerDTO dto);

    TigerMaster updateLastSighted(UUID tigerId, UpdateLastSightedDTO dto);

    void deleteTiger(UUID tigerId);
}
