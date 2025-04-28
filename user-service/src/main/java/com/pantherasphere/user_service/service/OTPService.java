package com.pantherasphere.user_service.service;

public interface OTPService {

    void generateAndSendOtp(String emailOrPhone);

    boolean verifyOtp(String emailOrPhone, String otpCode);
}
