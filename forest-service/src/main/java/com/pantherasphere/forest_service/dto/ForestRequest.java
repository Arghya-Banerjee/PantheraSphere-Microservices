package com.pantherasphere.forest_service.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.UUID;

@Data
public class ForestRequest {

    @NotBlank
    @Size(max = 100)
    private String forestName;

    @Positive
    private Double forestArea;

    @NotBlank
    @Size(max = 50)
    private String state;

    @NotNull
    private UUID forestTypeId;
}
