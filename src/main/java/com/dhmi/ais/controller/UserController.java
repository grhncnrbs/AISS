package com.dhmi.ais.controller;

import com.dhmi.ais.domain.dto.RegisterRequestDto;
import com.dhmi.ais.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> createUser(@Valid @RequestBody RegisterRequestDto request) {
        return userService.create(request);
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getAllUsers() {
        return userService.readAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getUser(@PathVariable(value = "id") Long id) {
        return userService.readById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        return userService.deleteUser(id);
    }
}
