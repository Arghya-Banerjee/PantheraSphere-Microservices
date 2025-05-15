package com.pantherasphere.forest_service.controller;

import com.pantherasphere.forest_service.dto.ForestTypeDTO;
import com.pantherasphere.forest_service.dto.ForestTypeRequest;
import com.pantherasphere.forest_service.service.ForestTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/forest-types")
@RequiredArgsConstructor
public class ForestTypeController {

    private final ForestTypeService forestTypeService;

    @PostMapping
    public ForestTypeDTO createForestType(@Valid @RequestBody ForestTypeRequest request) {
        return forestTypeService.createForestType(request);
    }

    @GetMapping
    public List<ForestTypeDTO> getAllForestTypes() {
        return forestTypeService.getAllForestTypes();
    }

    @GetMapping("/{forestTypeId}")
    public ForestTypeDTO getForestTypeById(@PathVariable UUID forestTypeId) {
        return forestTypeService.getForestTypeById(forestTypeId);
    }

    @PutMapping("/{forestTypeId}")
    public ForestTypeDTO updateForestType(@PathVariable UUID forestTypeId,
                                          @Valid @RequestBody ForestTypeRequest request) {
        return forestTypeService.updateForestType(forestTypeId, request);
    }

    @DeleteMapping("/{forestTypeId}")
    public void deleteForestType(@PathVariable UUID forestTypeId) {
        forestTypeService.deleteForestType(forestTypeId);
    }
}
