package com.vitora.modules.ai.service;

import com.vitora.modules.ai.dto.request.AiSuggestionRequest;
import com.vitora.modules.ai.dto.response.AiSuggestionResponse;

public interface AiSuggestionService {
    AiSuggestionResponse suggest(String email, AiSuggestionRequest request);
}
