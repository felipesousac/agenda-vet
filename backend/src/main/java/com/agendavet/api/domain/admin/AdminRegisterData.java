package com.agendavet.api.domain.admin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdminRegisterData(
        @NotBlank
        String name,
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotNull
        Boolean issuperadmin) {
}
