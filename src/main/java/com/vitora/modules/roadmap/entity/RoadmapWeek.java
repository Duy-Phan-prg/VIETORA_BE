package com.vitora.modules.roadmap.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "roadmap_weeks")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class RoadmapWeek {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roadmap_id", nullable = false)
    private Roadmap roadmap;

    private Integer weekNumber;
    private String focus;  // "Listening: Form Completion + Reading: TFNG"

    @OneToMany(mappedBy = "week", cascade = CascadeType.ALL)
    private List<RoadmapItem> items;
}
