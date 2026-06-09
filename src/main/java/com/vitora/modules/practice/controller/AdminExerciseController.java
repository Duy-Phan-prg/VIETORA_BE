package com.vitora.modules.practice.controller;

import com.vitora.common.response.ApiResponse;
import com.vitora.modules.practice.dto.request.CreateExerciseRequest;
import com.vitora.modules.practice.dto.response.ExerciseResponse;
import com.vitora.modules.practice.service.ExerciseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/exercises")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Admin - Exercise", description = "Quản lý bài luyện")
public class AdminExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ExerciseResponse> create(@Valid @RequestBody CreateExerciseRequest request) {
        return ApiResponse.success(exerciseService.create(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        exerciseService.delete(id);
    }
}
