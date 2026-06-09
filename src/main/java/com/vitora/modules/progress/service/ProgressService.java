package com.vitora.modules.progress.service;

import com.vitora.modules.practice.enums.Skill;
import com.vitora.modules.progress.dto.response.ProgressSummaryResponse;
import com.vitora.modules.progress.dto.response.SkillScoreResponse;

public interface ProgressService {
    ProgressSummaryResponse getSummary(String email);
    SkillScoreResponse getSkillScore(String email, Skill skill);
    void updateScore(Long userId, Skill skill, int score);
    void recordSession(Long userId, int durationMinutes);
}
