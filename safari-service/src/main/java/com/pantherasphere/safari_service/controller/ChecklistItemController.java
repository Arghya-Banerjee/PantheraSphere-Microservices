package com.pantherasphere.safari_service.controller;

import com.pantherasphere.safari_service.dto.ChecklistItemRequestDTO;
import com.pantherasphere.safari_service.dto.ChecklistItemResponseDTO;
import com.pantherasphere.safari_service.service.ChecklistItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/checklist-item")
@RequiredArgsConstructor
public class ChecklistItemController {

    private final ChecklistItemService checklistItemService;

    @PostMapping
    public ResponseEntity<ChecklistItemResponseDTO> createChecklistItem(@RequestBody ChecklistItemRequestDTO requestDTO) {
        return ResponseEntity.ok(checklistItemService.createChecklistItem(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistItemResponseDTO> getChecklistItemById(@PathVariable UUID id) {
        return ResponseEntity.ok(checklistItemService.getChecklistItemById(id));
    }

    @GetMapping
    public ResponseEntity<List<ChecklistItemResponseDTO>> getAllChecklistItems() {
        return ResponseEntity.ok(checklistItemService.getAllChecklistItems());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChecklistItem(@PathVariable UUID id) {
        checklistItemService.deleteChecklistItem(id);
        return ResponseEntity.noContent().build();
    }
}
