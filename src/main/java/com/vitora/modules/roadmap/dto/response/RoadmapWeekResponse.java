package com.vitora.modules.roadmap.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
public class RoadmapWeekResponse {
    private Integer weekNumber;
    private String focus;
    private List<RoadmapItemResponse> items;

    @Getter @Builder
    public static class RoadmapItemResponse {
        private Long id;
        private String itemType;
        private Long referenceId;
        private String title;
        private boolean completed;
    }
}
