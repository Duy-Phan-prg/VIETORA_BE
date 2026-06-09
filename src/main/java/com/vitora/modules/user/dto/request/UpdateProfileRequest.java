package com.vitora.modules.user.dto.request;

import com.vitora.modules.user.enums.TargetBand;
import lombok.Getter;

@Getter
public class UpdateProfileRequest {
    private String fullName;
    private String avatarUrl;
    private TargetBand targetBand;
}
