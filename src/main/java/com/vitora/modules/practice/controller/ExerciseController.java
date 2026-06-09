package com.vitora.modules.practice.controller;

import com.vitora.common.response.ApiResponse;
import com.vitora.common.response.PageResponse;
import com.vitora.modules.practice.dto.response.ExerciseDetailResponse;
import com.vitora.modules.practice.dto.response.ExerciseResponse;
import com.vitora.modules.practice.enums.ExerciseType;
import com.vitora.modules.practice.enums.Skill;
import com.vitora.modules.practice.service.ExerciseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exercises")
@RequiredArgsConstructor
@Tag(name = "Practice - Exercise", description = "Danh sách và chi tiết bài luyện")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    public ApiResponse<PageResponse<ExerciseResponse>> list(
            @RequestParam(required = false) Skill skill,
            @RequestParam(required = false) ExerciseType type,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ApiResponse.success(exerciseService.list(skill, type, page, size));
    }

    @GetMapping("/{id}")
    public ApiResponse<ExerciseDetailResponse> getDetail(@PathVariable Long id) {
        return ApiResponse.success(exerciseService.getDetail(id));
    }
}
