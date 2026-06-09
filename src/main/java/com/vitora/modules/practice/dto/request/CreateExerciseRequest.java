package com.vitora.modules.practice.dto.request;

import com.vitora.modules.practice.enums.ExerciseType;
import com.vitora.modules.practice.enums.Skill;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateExerciseRequest {
    @NotBlank private String title;
    private String description;
    private String audioUrl;
    private String passage;
    @NotNull private Skill skill;
    @NotNull private ExerciseType type;
    private Integer durationMinutes;
}
