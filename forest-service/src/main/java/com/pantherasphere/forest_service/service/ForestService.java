package com.pantherasphere.forest_service.service;

import com.pantherasphere.forest_service.entity.ForestMaster;

import java.util.List;
import java.util.UUID;

public interface ForestService {

    List<ForestMaster> getAllForests();
    ForestMaster getForestById(UUID id);
    List<ForestMaster> getForestsByTypeId(UUID typeId);
    List<ForestMaster> getForestsByState(String state);
    List<ForestMaster> searchForestsByName(String name);
    List<ForestMaster> getSortedForests(String by, String order);
    List<ForestMaster> getPaginatedForests(int page, int size);

    ForestMaster createForest(ForestMaster forest);
    ForestMaster updateForest(UUID id, ForestMaster updatedForest);
    void deleteForest(UUID id);

}
