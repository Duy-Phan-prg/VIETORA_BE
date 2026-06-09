package com.vitora.modules.note.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter @Builder
public class NoteResponse {
    private Long id;
    private String title;
    private String content;
    private Long exerciseId;
    private Long questionId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
