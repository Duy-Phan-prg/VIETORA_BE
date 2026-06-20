package com.vietora.modules.auth.service;

import com.vietora.modules.auth.payload.request.LoginRequest;
import com.vietora.modules.auth.payload.request.RefreshTokenRequest;
import com.vietora.modules.auth.payload.request.RegisterRequest;
import com.vietora.modules.auth.payload.response.AuthResponse;

public interface AuthService {
    void register(RegisterRequest request);
    void verifyEmail(String token);
    AuthResponse login(LoginRequest request);
    AuthResponse refreshToken(RefreshTokenRequest request);
    void logout(String refreshToken);
}
