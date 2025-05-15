package com.pantherasphere.forest_service.service.impl;

import com.pantherasphere.forest_service.dto.ForestDTO;
import com.pantherasphere.forest_service.dto.ForestRequest;
import com.pantherasphere.forest_service.entity.Forest;
import com.pantherasphere.forest_service.entity.ForestType;
import com.pantherasphere.forest_service.repository.ForestRepository;
import com.pantherasphere.forest_service.repository.ForestTypeRepository;
import com.pantherasphere.forest_service.service.ForestService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ForestServiceImpl implements ForestService {

    @Autowired
    private ForestRepository forestMasterRepository;

    @Autowired
    private ForestTypeRepository forestTypeMasterRepository;

    // ---- Helper: Entity → DTO ----
    private ForestDTO toDTO(Forest forest) {
        return new ForestDTO(
                forest.getForestId(),
                forest.getForestName(),
                forest.getForestArea(),
                forest.getState(),
                forest.getForestType().getForestTypeId()
        );
    }

    @Override
    public List<ForestDTO> getAllForests() {
        return forestMasterRepository.findAll()
                .stream().map(this::toDTO).toList();
    }

    @Override
    public ForestDTO getForestById(UUID id) {
        return toDTO(forestMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Forest not found with ID: " + id)));
    }

    @Override
    public List<ForestDTO> getForestsByTypeId(UUID typeId) {
        return forestMasterRepository.findByForestType_ForestTypeId(typeId)
                .stream().map(this::toDTO).toList();
    }

    @Override
    public List<ForestDTO> getForestsByState(String state) {
        return forestMasterRepository.findByStateIgnoreCase(state)
                .stream().map(this::toDTO).toList();
    }

    @Override
    public List<ForestDTO> searchForestsByName(String name) {
        return forestMasterRepository.findByForestNameContainingIgnoreCase(name)
                .stream().map(this::toDTO).toList();
    }

    @Override
    public List<ForestDTO> getSortedForests(String by, String order) {
        Sort.Direction sortOrder = order.equalsIgnoreCase("desc") ?
                Sort.Direction.DESC : Sort.Direction.ASC;

        return forestMasterRepository.findAll(Sort.by(sortOrder, by))
                .stream().map(this::toDTO).toList();
    }

    @Override
    public List<ForestDTO> getPaginatedForests(int page, int size) {
        return forestMasterRepository.findAll(PageRequest.of(page, size))
                .stream().map(this::toDTO).toList();
    }

    @Override
    public ForestDTO createForest(ForestRequest request) {

        ForestType type = forestTypeMasterRepository.findById(request.getForestTypeId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "ForestType not found with ID: " + request.getForestTypeId()));

        Forest forest = new Forest();
        forest.setForestName(request.getForestName());
        forest.setForestArea(request.getForestArea());
        forest.setState(request.getState());
        forest.setForestType(type);

        Forest saved = forestMasterRepository.save(forest);
        return toDTO(saved);
    }

    @Override
    public ForestDTO updateForest(UUID id, ForestRequest request) {

        Forest existing = forestMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Forest not found with ID: " + id));

        ForestType type = forestTypeMasterRepository.findById(request.getForestTypeId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "ForestType not found with ID: " + request.getForestTypeId()));

        existing.setForestName(request.getForestName());
        existing.setForestArea(request.getForestArea());
        existing.setState(request.getState());
        existing.setForestType(type);

        Forest updated = forestMasterRepository.save(existing);
        return toDTO(updated);
    }

    @Override
    public void deleteForest(UUID id) {
        forestMasterRepository.deleteById(id);
    }
}
