package com.vitora.modules.practice.repository;

import com.vitora.modules.practice.entity.Exercise;
import com.vitora.modules.practice.enums.ExerciseType;
import com.vitora.modules.practice.enums.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Page<Exercise> findBySkillAndPublishedTrue(Skill skill, Pageable pageable);
    Page<Exercise> findBySkillAndTypeAndPublishedTrue(Skill skill, ExerciseType type, Pageable pageable);
    Page<Exercise> findByPublishedTrue(Pageable pageable);
}
