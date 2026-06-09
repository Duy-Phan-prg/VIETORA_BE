package com.vitora.modules.practice.repository;

import com.vitora.modules.practice.entity.UserExercise;
import com.vitora.modules.practice.enums.ExerciseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserExerciseRepository extends JpaRepository<UserExercise, Long> {
    Optional<UserExercise> findByUserIdAndExerciseIdAndStatus(Long userId, Long exerciseId, ExerciseStatus status);
    Page<UserExercise> findByUserId(Long userId, Pageable pageable);
}
