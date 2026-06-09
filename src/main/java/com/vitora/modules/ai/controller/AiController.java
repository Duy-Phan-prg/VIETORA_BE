package com.vitora.modules.ai.controller;

import com.vitora.common.response.ApiResponse;
import com.vitora.common.util.AuthUtil;
import com.vitora.modules.ai.dto.request.AiSuggestionRequest;
import com.vitora.modules.ai.dto.response.AiSuggestionResponse;
import com.vitora.modules.ai.service.AiSuggestionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "AI", description = "Gợi ý AI dựa trên tiến độ học tập")
public class AiController {

    private final AiSuggestionService aiSuggestionService;

    @GetMapping("/suggestions")
    public ApiResponse<AiSuggestionResponse> suggest(
            @ModelAttribute AiSuggestionRequest request) {
        return ApiResponse.success(aiSuggestionService.suggest(AuthUtil.currentEmail(), request));
    }
}
