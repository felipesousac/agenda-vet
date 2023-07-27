package com.agendavet.api.domain.admin;

public record AdminListData(String name, String username) {

    public AdminListData(Admin admin) {
        this(admin.getName(), admin.getUsername());
    }
}
