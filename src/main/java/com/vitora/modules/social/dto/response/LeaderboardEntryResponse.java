package com.vitora.modules.social.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class LeaderboardEntryResponse {
    private int rank;
    private Long userId;
    private String fullName;
    private String avatarUrl;
    private Integer totalScore;
}
