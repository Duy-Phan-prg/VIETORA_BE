package com.vitora.modules.roadmap.service;

import com.vitora.modules.roadmap.dto.request.GenerateRoadmapRequest;
import com.vitora.modules.roadmap.dto.response.RoadmapResponse;

public interface RoadmapService {
    RoadmapResponse getMyRoadmap(String email);
    RoadmapResponse generate(String email, GenerateRoadmapRequest request);
    void markItemCompleted(String email, Long itemId);
}
