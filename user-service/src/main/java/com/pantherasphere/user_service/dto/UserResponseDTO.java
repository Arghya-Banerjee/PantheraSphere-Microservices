package com.pantherasphere.user_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseDTO {
    private UUID userId;
    private String userName;
    private String email;
    private String phoneNumber;
    private String roleName;
    private boolean is2FAEnabled;
}