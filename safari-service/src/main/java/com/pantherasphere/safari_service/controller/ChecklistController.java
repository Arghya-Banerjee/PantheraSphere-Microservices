package com.pantherasphere.safari_service.controller;

import com.pantherasphere.safari_service.dto.ChecklistResponse;
import com.pantherasphere.safari_service.dto.CreateChecklistRequest;
import com.pantherasphere.safari_service.service.ChecklistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/safari/checklist")
@RequiredArgsConstructor
public class ChecklistController {

    private final ChecklistService service;

    @PostMapping("/create")
    public ResponseEntity<ChecklistResponse> create(@RequestBody CreateChecklistRequest req) {
        return ResponseEntity.ok(service.createChecklist(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getChecklistById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChecklistResponse>> getAll() {
        return ResponseEntity.ok(service.getAllChecklists());
    }

    @PutMapping("/verify/{id}")
    public ResponseEntity<ChecklistResponse> verify(@PathVariable UUID id) {
        return ResponseEntity.ok(service.verifyChecklist(id));
    }
}
