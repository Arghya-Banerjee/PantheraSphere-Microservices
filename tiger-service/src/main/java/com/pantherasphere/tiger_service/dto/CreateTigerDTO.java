package com.pantherasphere.tiger_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateTigerDTO {
    private String name;
    private String gender;
    private Integer age;
    private UUID residentForestId;
}

