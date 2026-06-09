package com.vitora.modules.roadmap.dto.request;

import com.vitora.modules.user.enums.TargetBand;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class GenerateRoadmapRequest {
    @NotNull private TargetBand targetBand;
    @Min(4) @Max(24) private int weeksAvailable;
}
