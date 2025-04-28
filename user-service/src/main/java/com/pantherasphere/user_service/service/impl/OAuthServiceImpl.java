package com.pantherasphere.user_service.service.impl;

import com.pantherasphere.user_service.dto.OAuthLoginRequestDTO;
import com.pantherasphere.user_service.entity.RoleMaster;
import com.pantherasphere.user_service.entity.UserMaster;
import com.pantherasphere.user_service.repository.RoleRepository;
import com.pantherasphere.user_service.repository.UserRepository;
import com.pantherasphere.user_service.service.OAuthService;
import com.pantherasphere.user_service.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OAuthServiceImpl implements OAuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;

    @Override
    public String loginWithOAuth(OAuthLoginRequestDTO oauthRequest) {
        String provider = oauthRequest.getProvider().toLowerCase();
        String accessToken = oauthRequest.getAccessToken();

        // In real-world -> Validate accessToken with Google/Facebook APIs
        // For now -> Simulate token check
        if (!mockValidateOAuthAccessToken(provider, accessToken)) {
            throw new RuntimeException("Invalid OAuth Access Token");
        }

        // Extracted (mock) email from token
        String mockEmail = extractEmailFromAccessToken(provider, accessToken);

        Optional<UserMaster> existingUserOpt = userRepository.findByEmail(mockEmail);

        UserMaster user;
        if (existingUserOpt.isPresent()) {
            user = existingUserOpt.get();
        } else {
            // Register new user if not exists
            RoleMaster defaultRole = roleRepository.findByRoleName("NormalUser")
                    .orElseThrow(() -> new RuntimeException("Default role not found"));

            user = new UserMaster();
            user.setUserName("OAuth_" + provider + "_" + UUID.randomUUID().toString().substring(0, 8));
            user.setEmail(mockEmail);
            user.setPhoneNumber("N/A");
            user.setPassword(passwordEncoder.encode(UUID.randomUUID().toString())); // Dummy password
            user.setRole(defaultRole);
            user.setIs2FAEnabled(false); // No OTP required for OAuth login
            user.setCreatedAt(LocalDateTime.now());
            userRepository.save(user);
        }

        String token = jwtUtils.generateToken(user.getUserId(), user.getRole().getRoleName());
        return token;
    }

    private boolean mockValidateOAuthAccessToken(String provider, String accessToken) {
        // Simulate that any non-empty token is valid
        return accessToken != null && !accessToken.isEmpty();
    }

    private String extractEmailFromAccessToken(String provider, String accessToken) {
        // In reality, call Google/Facebook API and get email
        return "mockuser_" + provider + "@example.com";
    }
}
