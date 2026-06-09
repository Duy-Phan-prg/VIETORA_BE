package com.vitora.modules.practice.dto.request;

import lombok.Getter;

import java.util.Map;

@Getter
public class SubmitAnswerRequest {
    // questionId -> answer
    private Map<Long, String> answers;
}
