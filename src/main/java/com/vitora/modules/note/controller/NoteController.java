package com.vitora.modules.note.controller;

import com.vitora.common.response.ApiResponse;
import com.vitora.common.response.PageResponse;
import com.vitora.common.util.AuthUtil;
import com.vitora.modules.note.dto.request.NoteRequest;
import com.vitora.modules.note.dto.response.NoteResponse;
import com.vitora.modules.note.service.NoteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Note", description = "Ghi chú cá nhân")
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public ApiResponse<PageResponse<NoteResponse>> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return ApiResponse.success(noteService.list(AuthUtil.currentEmail(), page, size));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<NoteResponse> create(@RequestBody NoteRequest request) {
        return ApiResponse.success(noteService.create(AuthUtil.currentEmail(), request));
    }

    @PutMapping("/{id}")
    public ApiResponse<NoteResponse> update(@PathVariable Long id, @RequestBody NoteRequest request) {
        return ApiResponse.success(noteService.update(AuthUtil.currentEmail(), id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        noteService.delete(AuthUtil.currentEmail(), id);
    }
}
