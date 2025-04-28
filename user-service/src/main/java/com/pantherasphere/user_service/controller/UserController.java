package com.pantherasphere.user_service.controller;

import com.pantherasphere.user_service.dto.*;
import com.pantherasphere.user_service.service.OAuthService;
import com.pantherasphere.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final OAuthService oAuthService;

    // 1. User Registration
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequestDTO registerRequest) {
        userService.registerUser(registerRequest);
        return ResponseEntity.ok("Registration successful. OTP sent to your registered email/phone.");
    }

    // 2. User Login (Password Step)
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDTO loginRequest) {
        String message = userService.loginUser(loginRequest);
        return ResponseEntity.ok(message); // "OTP sent to registered email/phone"
    }

    // 3. OTP Verification (2FA Step)
    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody OtpVerificationDTO otpVerification) {
        String jwtToken = userService.verifyOtp(otpVerification);
        return ResponseEntity.ok(jwtToken);
    }

    // 4. OAuth Login (Google/Facebook etc.)
    @PostMapping("/oauth-login")
    public ResponseEntity<String> oauthLogin(@RequestBody OAuthLoginRequestDTO oauthRequest) {
        String jwtToken = oAuthService.loginWithOAuth(oauthRequest);
        return ResponseEntity.ok(jwtToken);
    }

    // 5. Fetch User Profile (by Email or Phone)
    @GetMapping("/profile")
    public ResponseEntity<UserResponseDTO> getUserProfile(@RequestParam("identifier") String emailOrPhone) {
        UserResponseDTO userProfile = userService.getUserProfile(emailOrPhone);
        return ResponseEntity.ok(userProfile);
    }
}
