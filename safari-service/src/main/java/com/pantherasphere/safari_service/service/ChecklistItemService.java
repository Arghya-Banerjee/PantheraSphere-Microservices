package com.pantherasphere.safari_service.service;

import com.pantherasphere.safari_service.dto.ChecklistItemRequestDTO;
import com.pantherasphere.safari_service.dto.ChecklistItemResponseDTO;

import java.util.List;
import java.util.UUID;

public interface ChecklistItemService {
    ChecklistItemResponseDTO createChecklistItem(ChecklistItemRequestDTO requestDTO);
    ChecklistItemResponseDTO getChecklistItemById(UUID id);
    List<ChecklistItemResponseDTO> getAllChecklistItems();
    void deleteChecklistItem(UUID id);
}
