package com.vitora.modules.progress.repository;

import com.vitora.modules.practice.enums.Skill;
import com.vitora.modules.progress.entity.SkillScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillScoreRepository extends JpaRepository<SkillScore, Long> {
    List<SkillScore> findByUserId(Long userId);
    Optional<SkillScore> findByUserIdAndSkill(Long userId, Skill skill);
}
