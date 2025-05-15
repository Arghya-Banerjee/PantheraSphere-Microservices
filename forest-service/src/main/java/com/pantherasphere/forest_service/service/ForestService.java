package com.pantherasphere.forest_service.service;

import com.pantherasphere.forest_service.dto.ForestDTO;
import com.pantherasphere.forest_service.dto.ForestRequest;

import java.util.List;
import java.util.UUID;

public interface ForestService {

    List<ForestDTO> getAllForests();
    ForestDTO getForestById(UUID id);
    List<ForestDTO> getForestsByTypeId(UUID typeId);
    List<ForestDTO> getForestsByState(String state);
    List<ForestDTO> searchForestsByName(String name);
    List<ForestDTO> getSortedForests(String by, String order);
    List<ForestDTO> getPaginatedForests(int page, int size);

    ForestDTO createForest(ForestRequest forestRequest);
    ForestDTO updateForest(UUID id, ForestRequest forestRequest);
    void deleteForest(UUID id);
}
