package com.vitora.modules.practice.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class SubmitResultResponse {
    private Long userExerciseId;
    private Double score;
    private Integer correctCount;
    private Integer totalCount;
    private String feedback;
}
