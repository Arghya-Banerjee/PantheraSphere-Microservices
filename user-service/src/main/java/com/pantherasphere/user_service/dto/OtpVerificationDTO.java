package com.pantherasphere.user_service.dto;

import lombok.Data;

@Data
public class OtpVerificationDTO {
    private String emailOrPhone;
    private String otpCode;
}
