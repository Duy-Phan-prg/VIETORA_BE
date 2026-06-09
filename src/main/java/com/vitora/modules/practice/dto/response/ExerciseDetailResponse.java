package com.vitora.modules.practice.dto.response;

import com.vitora.modules.practice.enums.ExerciseType;
import com.vitora.modules.practice.enums.Skill;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
public class ExerciseDetailResponse {
    private Long id;
    private String title;
    private String audioUrl;
    private String passage;
    private Skill skill;
    private ExerciseType type;
    private Integer durationMinutes;
    private List<QuestionResponse> questions;

    @Getter @Builder
    public static class QuestionResponse {
        private Long id;
        private Integer orderIndex;
        private String content;
        private String type;
        private List<ChoiceResponse> choices;
    }

    @Getter @Builder
    public static class ChoiceResponse {
        private Long id;
        private String label;
        private String content;
    }
}
