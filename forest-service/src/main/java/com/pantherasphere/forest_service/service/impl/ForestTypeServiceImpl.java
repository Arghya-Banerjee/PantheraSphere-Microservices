package com.pantherasphere.forest_service.service.impl;

import com.pantherasphere.forest_service.dto.ForestTypeDTO;
import com.pantherasphere.forest_service.dto.ForestTypeRequest;
import com.pantherasphere.forest_service.entity.ForestType;
import com.pantherasphere.forest_service.repository.ForestTypeRepository;
import com.pantherasphere.forest_service.service.ForestTypeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ForestTypeServiceImpl implements ForestTypeService {

    @Autowired
    private ForestTypeRepository forestTypeRepository;

    // --- Helper: Entity → DTO ---
    private ForestTypeDTO toDTO(ForestType entity) {
        return new ForestTypeDTO(
                entity.getForestTypeId(),
                entity.getForestTypeName(),
                entity.getDescription()
        );
    }

    @Override
    public ForestTypeDTO createForestType(ForestTypeRequest request) {
        ForestType type = new ForestType();
        type.setForestTypeName(request.getForestTypeName());
        type.setDescription(request.getDescription());

        ForestType saved = forestTypeRepository.save(type);
        return toDTO(saved);
    }

    @Override
    public List<ForestTypeDTO> getAllForestTypes() {
        return forestTypeRepository.findAll().stream()
                .map(this::toDTO).toList();
    }

    @Override
    public ForestTypeDTO getForestTypeById(UUID forestTypeId) {
        return toDTO(forestTypeRepository.findById(forestTypeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "ForestType not found with ID: " + forestTypeId)));
    }

    @Override
    public ForestTypeDTO updateForestType(UUID forestTypeId, ForestTypeRequest request) {
        ForestType existing = forestTypeRepository.findById(forestTypeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "ForestType not found with ID: " + forestTypeId));

        existing.setForestTypeName(request.getForestTypeName());
        existing.setDescription(request.getDescription());

        ForestType updated = forestTypeRepository.save(existing);
        return toDTO(updated);
    }

    @Override
    public void deleteForestType(UUID forestTypeId) {
        forestTypeRepository.deleteById(forestTypeId);
    }
}
