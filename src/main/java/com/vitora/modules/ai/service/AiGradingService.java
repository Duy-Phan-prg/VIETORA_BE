package com.vitora.modules.ai.service;

public interface AiGradingService {
    String gradeEssay(String taskPrompt, String studentAnswer);
    String gradeSpeaking(String audioUrl);
}
