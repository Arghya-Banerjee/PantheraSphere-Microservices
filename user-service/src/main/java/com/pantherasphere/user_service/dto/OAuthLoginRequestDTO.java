package com.pantherasphere.user_service.dto;

import lombok.Data;

@Data
public class OAuthLoginRequestDTO {
    private String provider; // Example: "google", "facebook"
    private String accessToken; // OAuth2 Access Token from Google/Facebook
}