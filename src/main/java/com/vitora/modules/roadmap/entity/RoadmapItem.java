package com.vitora.modules.roadmap.entity;

import com.vitora.modules.roadmap.enums.RoadmapItemType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roadmap_items")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class RoadmapItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "week_id", nullable = false)
    private RoadmapWeek week;

    @Enumerated(EnumType.STRING)
    private RoadmapItemType itemType;

    private Long referenceId;   // exercise_id, video_id, etc.
    private String title;
    private Integer orderIndex;
    private boolean completed;
}
