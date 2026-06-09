package com.vitora.modules.progress.dto.response;

import com.vitora.modules.practice.enums.Skill;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class SkillScoreResponse {
    private Skill skill;
    private Integer score;
}
