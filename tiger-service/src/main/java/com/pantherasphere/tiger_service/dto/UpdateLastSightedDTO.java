package com.pantherasphere.tiger_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateLastSightedDTO {
    private LocalDateTime lastSighted;
}

