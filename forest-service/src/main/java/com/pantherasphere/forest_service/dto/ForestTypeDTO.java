package com.pantherasphere.forest_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ForestTypeDTO {

    @NotNull
    private UUID forestTypeId;

    @NotBlank
    @Size(max = 100)
    private String forestTypeName;

    @NotBlank
    @Size(max = 512)
    private String description;
}
