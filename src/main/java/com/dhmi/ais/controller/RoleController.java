package com.dhmi.ais.controller;

import com.dhmi.ais.domain.entity.Role;
import com.dhmi.ais.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> createRole(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllRoles() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getRole(@PathVariable(value = "id") Long id ) {
        return roleService.getById(id);
    }

}
