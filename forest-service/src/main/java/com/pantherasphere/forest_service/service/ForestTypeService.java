package com.pantherasphere.forest_service.service;

import com.pantherasphere.forest_service.dto.ForestTypeDTO;
import com.pantherasphere.forest_service.dto.ForestTypeRequest;

import java.util.List;
import java.util.UUID;

public interface ForestTypeService {

    ForestTypeDTO createForestType(ForestTypeRequest request);

    List<ForestTypeDTO> getAllForestTypes();

    ForestTypeDTO getForestTypeById(UUID forestTypeId);

    ForestTypeDTO updateForestType(UUID forestTypeId, ForestTypeRequest request);

    void deleteForestType(UUID forestTypeId);
}
