package com.vitora.modules.note.dto.request;

import lombok.Getter;

@Getter
public class NoteRequest {
    private String title;
    private String content;
    private Long exerciseId;
    private Long questionId;
}
