package com.capfer.spring_boot_vue_crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record PatientDTO(
        long id,

        @NotBlank(message = "Name should not be null or empty")
        String name,

        @NotBlank(message = "Email should not be null or empty")
        String email,

        @NotBlank(message = "phoneNumber should not be null or empty")
        String phoneNumber,

        @NotBlank(message = "Gender should not be null or empty")
        String gender
) {
}
