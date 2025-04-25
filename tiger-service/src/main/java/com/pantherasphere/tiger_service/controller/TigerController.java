package com.pantherasphere.tiger_service.controller;

import com.pantherasphere.tiger_service.dto.CreateTigerDTO;
import com.pantherasphere.tiger_service.dto.UpdateLastSightedDTO;
import com.pantherasphere.tiger_service.entity.TigerMaster;
import com.pantherasphere.tiger_service.service.TigerService;
import com.pantherasphere.tiger_service.service.impl.TigerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tigers")
public class TigerController {

    @Autowired
    private TigerServiceImpl tigerService;

    @GetMapping
    public ResponseEntity<List<TigerMaster>> getAll() {
        return ResponseEntity.ok(tigerService.getAllTigers());
    }

    @GetMapping("/{tigerId}")
    public ResponseEntity<TigerMaster> getById(@PathVariable UUID tigerId) {
        return ResponseEntity.ok(tigerService.getTigerById(tigerId));
    }

    @GetMapping("/by-forest/{forestId}")
    public ResponseEntity<List<TigerMaster>> getByForest(@PathVariable UUID forestId) {
        return ResponseEntity.ok(tigerService.getTigersByForest(forestId));
    }

    @GetMapping("/by-gender")
    public ResponseEntity<List<TigerMaster>> getByGender(@RequestParam String gender) {
        return ResponseEntity.ok(tigerService.getTigersByGender(gender));
    }

    @GetMapping("/search")
    public ResponseEntity<List<TigerMaster>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(tigerService.searchTigersByName(name));
    }

    @GetMapping("/age-range")
    public ResponseEntity<List<TigerMaster>> getByAgeRange(@RequestParam int min, @RequestParam int max) {
        return ResponseEntity.ok(tigerService.getTigersByAgeRange(min, max));
    }

    @GetMapping("/last-sighted/recent")
    public ResponseEntity<List<TigerMaster>> getRecentSightings() {
        return ResponseEntity.ok(tigerService.getRecentlySightedTigers());
    }

    @PostMapping
    public ResponseEntity<TigerMaster> create(@RequestBody CreateTigerDTO dto) {
        return ResponseEntity.ok(tigerService.createTiger(dto));
    }

    @PutMapping("/{tigerId}")
    public ResponseEntity<TigerMaster> update(@PathVariable UUID tigerId, @RequestBody CreateTigerDTO dto) {
        return ResponseEntity.ok(tigerService.updateTiger(tigerId, dto));
    }

    @PatchMapping("/{tigerId}/last-sighted")
    public ResponseEntity<TigerMaster> updateLastSighted(@PathVariable UUID tigerId,
                                                         @RequestBody UpdateLastSightedDTO dto) {
        return ResponseEntity.ok(tigerService.updateLastSighted(tigerId, dto));
    }

    @DeleteMapping("/{tigerId}")
    public ResponseEntity<Void> delete(@PathVariable UUID tigerId) {
        tigerService.deleteTiger(tigerId);
        return ResponseEntity.noContent().build();
    }
}

