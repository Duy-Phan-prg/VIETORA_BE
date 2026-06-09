package com.vitora.modules.practice.service;

import com.vitora.common.response.PageResponse;
import com.vitora.modules.practice.dto.request.CreateExerciseRequest;
import com.vitora.modules.practice.dto.request.SubmitAnswerRequest;
import com.vitora.modules.practice.dto.response.ExerciseDetailResponse;
import com.vitora.modules.practice.dto.response.ExerciseResponse;
import com.vitora.modules.practice.dto.response.SubmitResultResponse;
import com.vitora.modules.practice.enums.ExerciseType;
import com.vitora.modules.practice.enums.Skill;

public interface ExerciseService {
    PageResponse<ExerciseResponse> list(Skill skill, ExerciseType type, int page, int size);
    ExerciseDetailResponse getDetail(Long id);
    Long start(String email, Long exerciseId);
    SubmitResultResponse submit(String email, Long userExerciseId, SubmitAnswerRequest request);
    PageResponse<ExerciseResponse> history(String email, int page, int size);

    // admin
    ExerciseResponse create(CreateExerciseRequest request);
    void delete(Long id);
}
