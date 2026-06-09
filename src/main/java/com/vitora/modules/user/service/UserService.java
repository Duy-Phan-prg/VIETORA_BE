package com.vitora.modules.user.service;

import com.vitora.modules.user.dto.request.UpdateProfileRequest;
import com.vitora.modules.user.dto.response.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(String email);
    UserProfileResponse updateProfile(String email, UpdateProfileRequest request);
}
