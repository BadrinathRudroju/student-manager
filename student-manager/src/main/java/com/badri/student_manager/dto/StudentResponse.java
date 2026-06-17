package com.badri.student_manager.dto;

import lombok.Builder;

@Builder
public record StudentResponse(
            Long id,
            String name,
            String email,
            String branch
) {
}
