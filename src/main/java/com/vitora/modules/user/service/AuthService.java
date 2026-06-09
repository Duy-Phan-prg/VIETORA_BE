package com.vitora.modules.user.service;

import com.vitora.modules.user.dto.request.LoginRequest;
import com.vitora.modules.user.dto.request.RegisterRequest;
import com.vitora.modules.user.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
    AuthResponse refresh(String refreshToken);
    void logout(String refreshToken);
}
