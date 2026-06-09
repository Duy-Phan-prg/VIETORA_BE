package com.vitora.modules.practice.dto.response;

import com.vitora.modules.practice.enums.ExerciseType;
import com.vitora.modules.practice.enums.Skill;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class ExerciseResponse {
    private Long id;
    private String title;
    private String description;
    private String thumbnailUrl;
    private Skill skill;
    private ExerciseType type;
    private Integer durationMinutes;
}
