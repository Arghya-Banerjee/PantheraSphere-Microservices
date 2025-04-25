package com.pantherasphere.forest_service.dto;

import lombok.Data;

@Data
public class ForestDto {

    private Long forestID;
    private String forestName;
    private Double forestArea;
    private String state;
    private String forestTypeName;

}
