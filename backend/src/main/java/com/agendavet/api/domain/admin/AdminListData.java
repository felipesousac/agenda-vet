package com.agendavet.api.domain.admin;

public record AdminListData(Long id, String name, String username) {

    public AdminListData(Admin admin) {
        this(admin.getId(), admin.getName(), admin.getUsername());
    }
}
