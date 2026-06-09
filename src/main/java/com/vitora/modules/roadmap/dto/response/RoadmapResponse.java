package com.vitora.modules.roadmap.dto.response;

import com.vitora.modules.user.enums.TargetBand;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
public class RoadmapResponse {
    private Long id;
    private TargetBand targetBand;
    private Integer totalWeeks;
    private List<RoadmapWeekResponse> weeks;
}
