package com.dhmi.ais.service;

import com.dhmi.ais.domain.entity.Role;
import org.springframework.http.ResponseEntity;

public interface RoleService {

    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> getByName(String name);
    ResponseEntity<?> create(Role role);
    ResponseEntity<?> getAll();
}
