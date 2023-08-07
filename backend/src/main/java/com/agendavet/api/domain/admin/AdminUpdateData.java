package com.agendavet.api.domain.admin;

import jakarta.validation.constraints.NotNull;

public record AdminUpdateData(@NotNull Long id, String name, String username, Boolean issuperadmin) {
}
