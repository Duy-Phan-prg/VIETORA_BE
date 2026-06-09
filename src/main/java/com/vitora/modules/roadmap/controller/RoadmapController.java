package com.vitora.modules.roadmap.controller;

import com.vitora.common.response.ApiResponse;
import com.vitora.common.util.AuthUtil;
import com.vitora.modules.roadmap.dto.request.GenerateRoadmapRequest;
import com.vitora.modules.roadmap.dto.response.RoadmapResponse;
import com.vitora.modules.roadmap.service.RoadmapService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roadmap")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Roadmap", description = "Lộ trình học tập cá nhân hóa")
public class RoadmapController {

    private final RoadmapService roadmapService;

    @GetMapping("/me")
    public ApiResponse<RoadmapResponse> getMyRoadmap() {
        return ApiResponse.success(roadmapService.getMyRoadmap(AuthUtil.currentEmail()));
    }

    @PostMapping("/generate")
    public ApiResponse<RoadmapResponse> generate(@Valid @RequestBody GenerateRoadmapRequest request) {
        return ApiResponse.success(roadmapService.generate(AuthUtil.currentEmail(), request));
    }

    @PatchMapping("/items/{itemId}/complete")
    public ApiResponse<Void> markComplete(@PathVariable Long itemId) {
        roadmapService.markItemCompleted(AuthUtil.currentEmail(), itemId);
        return ApiResponse.success(null);
    }
}
