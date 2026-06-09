package com.vitora.modules.progress.controller;

import com.vitora.common.response.ApiResponse;
import com.vitora.common.util.AuthUtil;
import com.vitora.modules.practice.enums.Skill;
import com.vitora.modules.progress.dto.response.ProgressSummaryResponse;
import com.vitora.modules.progress.dto.response.SkillScoreResponse;
import com.vitora.modules.progress.service.ProgressService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/progress")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Progress", description = "Tiến độ và điểm luyện đề")
public class ProgressController {

    private final ProgressService progressService;

    @GetMapping("/me")
    public ApiResponse<ProgressSummaryResponse> getSummary() {
        return ApiResponse.success(progressService.getSummary(AuthUtil.currentEmail()));
    }

    @GetMapping("/skill/{skill}")
    public ApiResponse<SkillScoreResponse> getSkillScore(@PathVariable Skill skill) {
        return ApiResponse.success(progressService.getSkillScore(AuthUtil.currentEmail(), skill));
    }
}
