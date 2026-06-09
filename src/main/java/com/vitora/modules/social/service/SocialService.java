package com.vitora.modules.social.service;

import com.vitora.modules.social.dto.response.FriendResponse;
import com.vitora.modules.social.dto.response.LeaderboardEntryResponse;

import java.util.List;

public interface SocialService {
    void sendRequest(String email, Long targetUserId);
    void acceptRequest(String email, Long friendshipId);
    void rejectRequest(String email, Long friendshipId);
    List<FriendResponse> listFriends(String email);
    List<FriendResponse> listPendingRequests(String email);
    List<LeaderboardEntryResponse> getLeaderboard(int limit);
}
