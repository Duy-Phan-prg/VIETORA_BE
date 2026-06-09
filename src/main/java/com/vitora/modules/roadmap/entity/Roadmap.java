package com.vitora.modules.roadmap.entity;

import com.vitora.modules.user.entity.User;
import com.vitora.modules.user.enums.TargetBand;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "roadmaps")
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Roadmap {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private TargetBand targetBand;

    private Integer totalWeeks;
    private boolean active;

    @OneToMany(mappedBy = "roadmap", cascade = CascadeType.ALL)
    @OrderBy("weekNumber ASC")
    private List<RoadmapWeek> weeks;

    @CreatedDate
    private LocalDateTime createdAt;
}
