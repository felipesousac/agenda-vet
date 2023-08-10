package com.agendavet.api.controller;

import com.agendavet.api.domain.admin.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/admin")
@SecurityRequirement(name = "bearer-key")
public class AdminController {
    @Autowired
    private AdminRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid AdminRegisterData data, UriComponentsBuilder uriBuilder) {
        var admin = new Admin(data);
        repository.save(admin);

        var uri = uriBuilder.path("/admin/{id}").buildAndExpand(admin.getId()).toUri();

        return ResponseEntity.created(uri).body(new AdminListData(admin));
    }

    @GetMapping
    public ResponseEntity<Page<AdminListData>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
        var page = repository.findAll(pagination).map(AdminListData::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var admin = repository.getReferenceById(id);

        return ResponseEntity.ok(new AdminListData(admin));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid AdminUpdateData data) {
        var admin = repository.getReferenceById(data.id());
        admin.updateData(data);

        return ResponseEntity.ok(new AdminListData(admin));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
