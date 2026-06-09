package com.vitora.modules.user.controller;

import com.vitora.common.response.ApiResponse;
import com.vitora.common.util.AuthUtil;
import com.vitora.modules.user.dto.request.UpdateProfileRequest;
import com.vitora.modules.user.dto.response.UserProfileResponse;
import com.vitora.modules.user.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/me")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "User", description = "Thông tin cá nhân")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ApiResponse<UserProfileResponse> getProfile() {
        return ApiResponse.success(userService.getProfile(AuthUtil.currentEmail()));
    }

    @PutMapping
    public ApiResponse<UserProfileResponse> updateProfile(@RequestBody UpdateProfileRequest request) {
        return ApiResponse.success(userService.updateProfile(AuthUtil.currentEmail(), request));
    }
}
