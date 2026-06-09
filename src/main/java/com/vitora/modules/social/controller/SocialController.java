package com.vitora.modules.social.controller;

import com.vitora.common.response.ApiResponse;
import com.vitora.common.util.AuthUtil;
import com.vitora.modules.social.dto.response.FriendResponse;
import com.vitora.modules.social.dto.response.LeaderboardEntryResponse;
import com.vitora.modules.social.service.SocialService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Social", description = "Bạn bè và bảng xếp hạng")
public class SocialController {

    private final SocialService socialService;

    @GetMapping("/api/v1/friends")
    public ApiResponse<List<FriendResponse>> listFriends() {
        return ApiResponse.success(socialService.listFriends(AuthUtil.currentEmail()));
    }

    @GetMapping("/api/v1/friends/requests")
    public ApiResponse<List<FriendResponse>> pendingRequests() {
        return ApiResponse.success(socialService.listPendingRequests(AuthUtil.currentEmail()));
    }

    @PostMapping("/api/v1/friends/{userId}/request")
    public ApiResponse<Void> sendRequest(@PathVariable Long userId) {
        socialService.sendRequest(AuthUtil.currentEmail(), userId);
        return ApiResponse.success(null);
    }

    @PostMapping("/api/v1/friends/{friendshipId}/accept")
    public ApiResponse<Void> accept(@PathVariable Long friendshipId) {
        socialService.acceptRequest(AuthUtil.currentEmail(), friendshipId);
        return ApiResponse.success(null);
    }

    @GetMapping("/api/v1/leaderboard")
    public ApiResponse<List<LeaderboardEntryResponse>> leaderboard(
            @RequestParam(defaultValue = "20") int limit) {
        return ApiResponse.success(socialService.getLeaderboard(limit));
    }
}
