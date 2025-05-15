package com.pantherasphere.forest_service.controller;

import com.pantherasphere.forest_service.dto.ForestDTO;
import com.pantherasphere.forest_service.dto.ForestRequest;
import com.pantherasphere.forest_service.service.ForestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/forest")
@RequiredArgsConstructor
public class ForestController {

    private final ForestService forestService;

    @GetMapping
    public ResponseEntity<List<ForestDTO>> getAllForests() {
        return ResponseEntity.ok(forestService.getAllForests());
    }

    @GetMapping("/{forestId}")
    public ResponseEntity<ForestDTO> getForestById(@PathVariable UUID forestId) {
        return ResponseEntity.ok(forestService.getForestById(forestId));
    }

    @GetMapping("/by-type/{typeId}")
    public ResponseEntity<List<ForestDTO>> getForestsByType(@PathVariable UUID typeId) {
        return ResponseEntity.ok(forestService.getForestsByTypeId(typeId));
    }

    @GetMapping("/by-state")
    public ResponseEntity<List<ForestDTO>> getForestsByState(@RequestParam String state) {
        return ResponseEntity.ok(forestService.getForestsByState(state));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ForestDTO>> searchForestsByName(@RequestParam String name) {
        return ResponseEntity.ok(forestService.searchForestsByName(name));
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<ForestDTO>> getSortedForests(
            @RequestParam(defaultValue = "forestName") String by,
            @RequestParam(defaultValue = "asc") String order) {
        return ResponseEntity.ok(forestService.getSortedForests(by, order));
    }

    @GetMapping("/paginated")
    public ResponseEntity<List<ForestDTO>> getPaginatedForests(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(forestService.getPaginatedForests(page, size));
    }

    @PostMapping
    public ResponseEntity<ForestDTO> createForest(@Valid @RequestBody ForestRequest request) {
        return ResponseEntity.ok(forestService.createForest(request));
    }

    @PutMapping("/{forestId}")
    public ResponseEntity<ForestDTO> updateForest(@PathVariable UUID forestId,
                                                  @Valid @RequestBody ForestRequest request) {
        return ResponseEntity.ok(forestService.updateForest(forestId, request));
    }

    @DeleteMapping("/{forestId}")
    public ResponseEntity<Void> deleteForest(@PathVariable UUID forestId) {
        forestService.deleteForest(forestId);
        return ResponseEntity.noContent().build();
    }
}
