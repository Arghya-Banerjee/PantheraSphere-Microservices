package com.pantherasphere.forest_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ForestTypeRequest {

    @NotBlank
    @Size(max = 50)
    private String forestTypeName;

    @NotBlank
    @Size(max = 512)
    private String description;
}
