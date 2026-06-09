package com.vitora.modules.practice.controller;

import com.vitora.common.response.ApiResponse;
import com.vitora.common.response.PageResponse;
import com.vitora.common.util.AuthUtil;
import com.vitora.modules.practice.dto.request.SubmitAnswerRequest;
import com.vitora.modules.practice.dto.response.ExerciseResponse;
import com.vitora.modules.practice.dto.response.SubmitResultResponse;
import com.vitora.modules.practice.service.ExerciseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Practice - User", description = "Bắt đầu và nộp bài luyện")
public class UserExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping("/{id}/start")
    public ApiResponse<Long> start(@PathVariable Long id) {
        return ApiResponse.success(exerciseService.start(AuthUtil.currentEmail(), id));
    }

    @PostMapping("/sessions/{sessionId}/submit")
    public ApiResponse<SubmitResultResponse> submit(
            @PathVariable Long sessionId,
            @RequestBody SubmitAnswerRequest request) {
        return ApiResponse.success(exerciseService.submit(AuthUtil.currentEmail(), sessionId, request));
    }

    @GetMapping("/history")
    public ApiResponse<PageResponse<ExerciseResponse>> history(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ApiResponse.success(exerciseService.history(AuthUtil.currentEmail(), page, size));
    }
}
