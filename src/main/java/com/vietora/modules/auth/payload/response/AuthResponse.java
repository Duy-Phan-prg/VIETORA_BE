package com.vietora.modules.auth.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data @Builder
public class AuthResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private String id;
    private String fullName;
    private String username;
    private String email;
    private Set<String> roles;
}
