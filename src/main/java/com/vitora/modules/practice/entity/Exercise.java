package com.vitora.modules.practice.entity;

import com.vitora.modules.practice.enums.ExerciseType;
import com.vitora.modules.practice.enums.Skill;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "exercises")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Exercise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private String thumbnailUrl;
    private String audioUrl;    // for LISTENING
    private String passage;     // for READING

    @Enumerated(EnumType.STRING)
    private Skill skill;

    @Enumerated(EnumType.STRING)
    private ExerciseType type;

    private Integer durationMinutes;
    private boolean published;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL)
    private List<Question> questions;

    @CreatedDate
    private LocalDateTime createdAt;
}
