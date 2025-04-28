package com.pantherasphere.user_service.service;

import com.pantherasphere.user_service.dto.OAuthLoginRequestDTO;

public interface OAuthService {

    String loginWithOAuth(OAuthLoginRequestDTO oauthRequest);
}
