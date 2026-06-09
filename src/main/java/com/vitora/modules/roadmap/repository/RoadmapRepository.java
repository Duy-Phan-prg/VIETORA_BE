package com.vitora.modules.roadmap.repository;

import com.vitora.modules.roadmap.entity.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoadmapRepository extends JpaRepository<Roadmap, Long> {
    Optional<Roadmap> findByUserIdAndActiveTrue(Long userId);
}
