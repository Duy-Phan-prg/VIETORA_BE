package com.vitora.modules.note.service;

import com.vitora.common.response.PageResponse;
import com.vitora.modules.note.dto.request.NoteRequest;
import com.vitora.modules.note.dto.response.NoteResponse;

public interface NoteService {
    PageResponse<NoteResponse> list(String email, int page, int size);
    NoteResponse create(String email, NoteRequest request);
    NoteResponse update(String email, Long id, NoteRequest request);
    void delete(String email, Long id);
}
