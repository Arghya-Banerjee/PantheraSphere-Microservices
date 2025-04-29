package com.pantherasphere.safari_service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ChecklistResponse {
    private UUID checklistId;
    private UUID forestId;
    private UUID createdBy;
    private LocalDate safariDate;
    private LocalTime startTime;
    private UUID guideId;
    private UUID driverId;
    private Boolean verified;
    private LocalDateTime modifiedAt;
}
