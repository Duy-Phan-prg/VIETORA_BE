package com.vitora.modules.social.repository;

import com.vitora.modules.social.entity.Friendship;
import com.vitora.modules.social.enums.FriendshipStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    @Query("SELECT f FROM Friendship f WHERE (f.requester.id = :userId OR f.addressee.id = :userId) AND f.status = :status")
    List<Friendship> findByUserIdAndStatus(Long userId, FriendshipStatus status);

    Optional<Friendship> findByRequesterIdAndAddresseeId(Long requesterId, Long addresseeId);
}
