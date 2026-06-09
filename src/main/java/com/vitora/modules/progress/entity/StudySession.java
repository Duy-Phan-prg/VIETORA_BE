package com.vitora.modules.progress.entity;

import com.vitora.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "study_sessions")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class StudySession {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate date;
    private Integer durationMinutes;
    private Integer exercisesCompleted;
}
