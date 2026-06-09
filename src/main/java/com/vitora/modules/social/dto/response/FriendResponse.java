package com.vitora.modules.social.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class FriendResponse {
    private Long userId;
    private String fullName;
    private String avatarUrl;
    private String status;
}
