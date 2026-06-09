package com.vitora.modules.practice.service;

import com.vitora.modules.practice.entity.Question;
import com.vitora.modules.practice.entity.UserAnswer;

import java.util.List;

public interface GradingService {
    boolean gradeObjective(Question question, String answer);
    String gradeEssay(String prompt, String answer);  // calls AI
    double calculateScore(List<UserAnswer> answers, int totalQuestions);
}
