package com.pantherasphere.user_service.service;

import com.pantherasphere.user_service.dto.*;

public interface UserService {

    void registerUser(RegisterRequestDTO registerRequest);

    String loginUser(LoginRequestDTO loginRequest);

    String verifyOtp(OtpVerificationDTO otpVerification);

    UserResponseDTO getUserProfile(String emailOrPhone);
}
