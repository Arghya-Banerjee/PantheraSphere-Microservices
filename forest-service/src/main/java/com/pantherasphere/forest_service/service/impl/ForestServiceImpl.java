package com.pantherasphere.forest_service.service.impl;

import com.pantherasphere.forest_service.entity.ForestMaster;
import com.pantherasphere.forest_service.entity.ForestTypeMaster;
import com.pantherasphere.forest_service.repository.ForestMasterRepository;
import com.pantherasphere.forest_service.repository.ForestTypeMasterRepository;
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
    private ForestMasterRepository forestMasterRepository;
    @Autowired
    private ForestTypeMasterRepository forestTypeMasterRepository;

    @Override
    public List<ForestMaster> getAllForests() {
        return forestMasterRepository.findAll();
    }

    @Override
    public ForestMaster getForestById(UUID id) {
        return forestMasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Forest not found with Id: " + id));
    }

    @Override
    public List<ForestMaster> getForestsByTypeId(UUID typeId) {
        return forestMasterRepository.findByForestType_ForestTypeId(typeId);
    }

    @Override
    public List<ForestMaster> getForestsByState(String state) {
        return forestMasterRepository.findByStateIgnoreCase(state);
    }

    @Override
    public List<ForestMaster> searchForestsByName(String name) {
        return forestMasterRepository.findByForestNameContainingIgnoreCase(name);
    }

    @Override
    public List<ForestMaster> getSortedForests(String by, String order) {
        Sort.Direction sortOrder = order.equalsIgnoreCase("desc") ?
                Sort.Direction.DESC : Sort.Direction.ASC;
        return forestMasterRepository.findAll(Sort.by(sortOrder, by));
    }

    @Override
    public List<ForestMaster> getPaginatedForests(int page, int size) {
        return forestMasterRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public ForestMaster createForest(ForestMaster forest) {
        if (forest.getForestType() == null || forest.getForestType().getForestTypeId() == null) {
            throw new IllegalArgumentException("ForestTypeID must not be null when creating a Forest");
        }

        UUID typeId = forest.getForestType().getForestTypeId();
        ForestTypeMaster type = forestTypeMasterRepository.findById(typeId)
                .orElseThrow(() -> new EntityNotFoundException("ForestType not found with ID: " + typeId));

        forest.setForestType(type);
        return forestMasterRepository.save(forest);
    }

    @Override
    public ForestMaster updateForest(UUID id, ForestMaster updatedForest) {
        ForestMaster existing = getForestById(id);

        existing.setForestName(updatedForest.getForestName());
        existing.setForestArea(updatedForest.getForestArea());
        existing.setState(updatedForest.getState());

        if (updatedForest.getForestType() == null || updatedForest.getForestType().getForestTypeId() == null) {
            throw new IllegalArgumentException("ForestTypeID must not be null when updating a Forest");
        }

        UUID typeId = updatedForest.getForestType().getForestTypeId();
        ForestTypeMaster type = forestTypeMasterRepository.findById(typeId)
                .orElseThrow(() -> new EntityNotFoundException("ForestType not found with ID: " + typeId));
        existing.setForestType(type);

        return forestMasterRepository.save(existing);
    }

    @Override
    public void deleteForest(UUID id) {
        forestMasterRepository.deleteById(id);
    }
}
