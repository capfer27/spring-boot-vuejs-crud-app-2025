package com.capfer.spring_boot_vue_crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record UpdatePatientDTO(
        long id,
        @NotBlank(message = "name must not be empty")
        String name,
        @NotBlank(message = "email must not be empty")
        String email,
        @NotBlank(message = "phone number must not be empty")
        String phoneNumber,
        @NotBlank(message = "gender must not be empty")
        String gender
) {
}
