package com.pantherasphere.user_service.service.impl;

import com.pantherasphere.user_service.dto.*;
import com.pantherasphere.user_service.entity.RoleMaster;
import com.pantherasphere.user_service.entity.UserMaster;
import com.pantherasphere.user_service.repository.RoleRepository;
import com.pantherasphere.user_service.repository.UserRepository;
import com.pantherasphere.user_service.service.UserService;
import com.pantherasphere.user_service.service.OTPService;
import com.pantherasphere.user_service.utils.JWTUtils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final OTPService otpService; // We'll build this too
    private final JWTUtils jwtUtils;

    @Override
    public void registerUser(RegisterRequestDTO registerRequest) {
        if (userRepository.existsByEmail(registerRequest.getEmail()) ||
                userRepository.existsByPhoneNumber(registerRequest.getPhoneNumber())) {
            throw new RuntimeException("User with given email or phone already exists");
        }

        RoleMaster role = roleRepository.findById(registerRequest.getRoleId())
                .orElseThrow(() -> new RuntimeException("Invalid role ID"));

        UserMaster user = new UserMaster();
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(role);
        user.setIs2FAEnabled(true);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);

        // Send OTP after registration
        otpService.generateAndSendOtp(user.getEmail());
    }

    @Override
    public String loginUser(LoginRequestDTO loginRequest) {
        Optional<UserMaster> optionalUser = userRepository.findByEmailOrPhoneNumber(
                loginRequest.getEmailOrPhone(), loginRequest.getEmailOrPhone());

        UserMaster user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Send OTP after password verification
        otpService.generateAndSendOtp(user.getEmail());

        return "OTP sent to registered email/phone";
    }

    @Override
    public String verifyOtp(OtpVerificationDTO otpVerification) {
        Optional<UserMaster> optionalUser = userRepository.findByEmailOrPhoneNumber(
                otpVerification.getEmailOrPhone(), otpVerification.getEmailOrPhone());

        UserMaster user = optionalUser.orElseThrow(() -> new RuntimeException("User not found"));

        if (otpService.verifyOtp(otpVerification.getEmailOrPhone(), otpVerification.getOtpCode())) {
            String token = jwtUtils.generateToken(user.getUserId(), user.getRole().getRoleName());
            return token;
        } else {
            throw new RuntimeException("Invalid OTP");
        }
    }

    @Override
    public UserResponseDTO getUserProfile(String emailOrPhone) {
        UserMaster user = userRepository.findByEmailOrPhoneNumber(emailOrPhone, emailOrPhone)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserResponseDTO response = new UserResponseDTO();
        response.setUserId(user.getUserId());
        response.setUserName(user.getUserName());
        response.setEmail(user.getEmail());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setRoleName(user.getRole().getRoleName());
        response.set2FAEnabled(user.getIs2FAEnabled());

        return response;
    }
}
