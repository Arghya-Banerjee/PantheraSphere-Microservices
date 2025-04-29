package com.pantherasphere.safari_service.service;

import com.pantherasphere.safari_service.dto.ChecklistResponse;
import com.pantherasphere.safari_service.dto.CreateChecklistRequest;

import java.util.List;
import java.util.UUID;

public interface ChecklistService {
    ChecklistResponse createChecklist(CreateChecklistRequest request);
    ChecklistResponse getChecklistById(UUID checklistId);
    List<ChecklistResponse> getAllChecklists();
    ChecklistResponse verifyChecklist(UUID checklistId);
}
