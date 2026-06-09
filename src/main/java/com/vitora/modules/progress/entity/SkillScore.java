package com.vitora.modules.progress.entity;

import com.vitora.modules.practice.enums.Skill;
import com.vitora.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "skill_scores")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class SkillScore {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private Skill skill;

    private Integer score;
    private LocalDateTime updatedAt;
}
