package com.pantherasphere.safari_service.dto;

import lombok.Data;

import java.sql.Time;
import java.util.UUID;

@Data
public class ChecklistItemResponseDTO {
    private UUID checklistItemId;
    private UUID checklistId;
    private UUID tigerId;
    private String seenBy;
    private Time seenTime;
    private String observationNotes;
}
