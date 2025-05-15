package com.pantherasphere.forest_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ForestDTO {

    private UUID forestID;
    private String forestName;
    private Double forestArea;
    private String state;
    private UUID forestTypeName;

}
