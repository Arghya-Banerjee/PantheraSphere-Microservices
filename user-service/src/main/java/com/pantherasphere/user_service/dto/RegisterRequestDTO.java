package com.pantherasphere.user_service.dto;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
    private Integer roleId; // We pass roleId directly (1 = Admin, 2 = User)
}
