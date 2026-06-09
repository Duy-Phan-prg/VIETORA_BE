package com.vitora.modules.practice.entity;

import com.vitora.modules.practice.enums.ExerciseStatus;
import com.vitora.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_exercises")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class UserExercise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Enumerated(EnumType.STRING)
    private ExerciseStatus status;

    private Double score;
    private Integer correctCount;
    private Integer totalCount;

    private LocalDateTime startedAt;
    private LocalDateTime completedAt;

    @OneToMany(mappedBy = "userExercise", cascade = CascadeType.ALL)
    private List<UserAnswer> answers;
}
