package com.vitora.modules.practice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_answers")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class UserAnswer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_exercise_id", nullable = false)
    private UserExercise userExercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(columnDefinition = "TEXT")
    private String answer;

    private boolean correct;
    private String aiFeedback;  // for ESSAY / RECORDING
}
