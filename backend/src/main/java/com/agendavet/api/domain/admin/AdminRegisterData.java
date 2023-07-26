package com.agendavet.api.domain.admin;

public record AdminRegisterData(
        String name,
        String username,
        String password,
        Boolean issuperadmin) {
}
