package com.pantherasphere.user_service.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String emailOrPhone;
    private String password;
}