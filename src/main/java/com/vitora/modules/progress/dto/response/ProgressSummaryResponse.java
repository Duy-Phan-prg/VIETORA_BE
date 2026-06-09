package com.vitora.modules.progress.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
public class ProgressSummaryResponse {
    private List<SkillScoreResponse> skillScores;
    private int currentStreak;
    private int totalExercisesCompleted;
}
