package com.vitora.config;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
    public String generateAccessToken(String email) { return null; }
    public String generateRefreshToken(String email) { return null; }
    public String extractEmail(String token) { return null; }
    public boolean isValid(String token) { return false; }
}
