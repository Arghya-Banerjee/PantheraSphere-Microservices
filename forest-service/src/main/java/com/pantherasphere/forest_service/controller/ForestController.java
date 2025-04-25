package com.pantherasphere.forest_service.controller;

import com.pantherasphere.forest_service.entity.ForestMaster;
import com.pantherasphere.forest_service.service.ForestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/forest")
public class ForestController {

    @Autowired
    private ForestService forestService;

    // GET all forests
    @GetMapping
    public ResponseEntity<List<ForestMaster>> getAllForests() {
        return ResponseEntity.ok(forestService.getAllForests());
    }

    // GET forest by ID
    @GetMapping("/{forestId}")
    public ResponseEntity<ForestMaster> getForestById(@PathVariable UUID forestId) {
        return ResponseEntity.ok(forestService.getForestById(forestId));
    }

    // GET forests by forestTypeId
    @GetMapping("/by-type/{typeId}")
    public ResponseEntity<List<ForestMaster>> getForestsByType(@PathVariable UUID typeId) {
        return ResponseEntity.ok(forestService.getForestsByTypeId(typeId));
    }

    // GET forests by state
    @GetMapping("/by-state")
    public ResponseEntity<List<ForestMaster>> getForestsByState(@RequestParam String state) {
        return ResponseEntity.ok(forestService.getForestsByState(state));
    }

    // GET forests by name search
    @GetMapping("/search")
    public ResponseEntity<List<ForestMaster>> searchForestsByName(@RequestParam String name) {
        return ResponseEntity.ok(forestService.searchForestsByName(name));
    }

    // GET sorted forests
    @GetMapping("/sorted")
    public ResponseEntity<List<ForestMaster>> getSortedForests(
            @RequestParam(defaultValue = "forestName") String by,
            @RequestParam(defaultValue = "asc") String order) {
        return ResponseEntity.ok(forestService.getSortedForests(by, order));
    }

    // GET paginated forests
    @GetMapping("/paginated")
    public ResponseEntity<List<ForestMaster>> getPaginatedForests(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(forestService.getPaginatedForests(page, size));
    }

    // POST create forest
    @PostMapping
    public ResponseEntity<ForestMaster> createForest(@RequestBody ForestMaster forest) {
        return ResponseEntity.ok(forestService.createForest(forest));
    }

    // PUT update forest
    @PutMapping("/{forestId}")
    public ResponseEntity<ForestMaster> updateForest(@PathVariable UUID forestId,
                                                     @RequestBody ForestMaster updatedForest) {
        return ResponseEntity.ok(forestService.updateForest(forestId, updatedForest));
    }

    // DELETE forest
    @DeleteMapping("/{forestId}")
    public ResponseEntity<Void> deleteForest(@PathVariable UUID forestId) {
        forestService.deleteForest(forestId);
        return ResponseEntity.noContent().build();
    }

}
