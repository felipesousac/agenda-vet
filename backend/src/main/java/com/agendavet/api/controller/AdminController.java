package com.agendavet.api.controller;

import com.agendavet.api.domain.admin.Admin;
import com.agendavet.api.domain.admin.AdminRegisterData;
import com.agendavet.api.domain.admin.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid AdminRegisterData data) {

        repository.save(new Admin(data));
    }


}
