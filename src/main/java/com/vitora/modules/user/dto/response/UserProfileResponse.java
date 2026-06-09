package com.vitora.modules.user.dto.response;

import com.vitora.modules.user.enums.Role;
import com.vitora.modules.user.enums.TargetBand;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class UserProfileResponse {
    private Long id;
    private String email;
    private String fullName;
    private String avatarUrl;
    private Role role;
    private TargetBand targetBand;
}
