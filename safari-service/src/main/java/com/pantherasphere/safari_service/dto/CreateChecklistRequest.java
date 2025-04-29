package com.pantherasphere.safari_service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class CreateChecklistRequest {
    private UUID forestId;
    private UUID createdBy;
    private LocalDate safariDate;
    private LocalTime startTime;
    private UUID guideId;
    private UUID driverId;
}
