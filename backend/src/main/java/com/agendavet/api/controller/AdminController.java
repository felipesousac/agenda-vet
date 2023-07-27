package com.agendavet.api.controller;

import com.agendavet.api.domain.admin.Admin;
import com.agendavet.api.domain.admin.AdminListData;
import com.agendavet.api.domain.admin.AdminRegisterData;
import com.agendavet.api.domain.admin.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<AdminListData> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        return repository.findAll(pagination).map(AdminListData::new);
    }
}
