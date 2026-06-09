package com.vitora.modules.ai.dto.request;

import com.vitora.modules.practice.enums.Skill;
import lombok.Getter;

@Getter
public class AiSuggestionRequest {
    private Skill focusSkill;   // optional: gợi ý tập trung vào 1 kỹ năng cụ thể
}
