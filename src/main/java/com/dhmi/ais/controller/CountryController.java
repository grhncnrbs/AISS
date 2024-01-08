package com.dhmi.ais.controller;

import com.dhmi.ais.domain.entity.Country;
import com.dhmi.ais.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> create(@RequestBody Country country) {
        return countryService.create(country);
    }

    @GetMapping("/countries")
    public ResponseEntity<?> getAllCountries() {
        return countryService.getAll();
    }
}
