package com.pantherasphere.safari_service.controller;

import com.pantherasphere.safari_service.entity.GuideMaster;
import com.pantherasphere.safari_service.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/safari/guide")
@RequiredArgsConstructor
public class GuideController {

    private final GuideService guideService;

    @PostMapping("/add")
    public ResponseEntity<GuideMaster> addGuide(@RequestBody GuideMaster guide) {
        return ResponseEntity.ok(guideService.addGuide(guide));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideMaster> getGuide(@PathVariable UUID id) {
        return ResponseEntity.ok(guideService.getGuide(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GuideMaster>> getAllGuides() {
        return ResponseEntity.ok(guideService.getAllGuides());
    }
}