package com.badri.student_manager.dto;

import jakarta.validation.constraints.*;


public record StudentRequest(
        @NotBlank(message = "It should have a name")
        @Size(min = 2, max = 50, message= "name should be betweeen 2 to 50 characters")
        String name,

        @NotBlank(message = "email is mandatory")
        @Email(message = "email must be valid")
        String email,

        @Min(value = 1, message = "age should be at least 1")
        @Max(value = 100, message ="age should not exceed 100")
        String branch
) {
}
