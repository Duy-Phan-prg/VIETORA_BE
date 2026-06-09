package com.vitora.modules.ai.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
public class AiSuggestionResponse {
    private String summary;             // "Bạn yếu Listening, nên tập trung vào..."
    private List<SuggestedExercise> exercises;

    @Getter @Builder
    public static class SuggestedExercise {
        private Long exerciseId;
        private String title;
        private String skill;
        private String reason;
    }
}
