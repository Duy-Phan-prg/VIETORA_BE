package com.vitora.modules.progress.repository;

import com.vitora.modules.progress.entity.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {
    List<StudySession> findByUserIdAndDateBetween(Long userId, LocalDate from, LocalDate to);
}
