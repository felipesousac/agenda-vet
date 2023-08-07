package com.agendavet.api.domain.admin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "administrators")
@Entity(name = "Admin")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;


    private Boolean issuperadmin;
    // Quais as permissões que o administrador poderá ter?
    // Por enquanto criar ou excluir outros admins

    public Admin(AdminRegisterData data) {
        this.name = data.name();
        this.username = data.username();
        this.password = data.password();
        this.issuperadmin = data.issuperadmin();
    }

    public void updateData(AdminUpdateData data) {
        if (data.name() != null) {
            this.name = data.name();
        }

        if (data.username() != null) {
            this.username = data.username();
        }

        if (data.issuperadmin() != null) {
            this.issuperadmin = data.issuperadmin();
        }

    }
}
