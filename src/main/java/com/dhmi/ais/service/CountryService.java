package com.dhmi.ais.service;

import com.dhmi.ais.domain.entity.Country;
import org.springframework.http.ResponseEntity;

public interface CountryService {

    ResponseEntity<?> create(Country country);
    ResponseEntity<?> deleteById(Long id);
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> getAll();
    ResponseEntity<?> getByName(String name);

}
