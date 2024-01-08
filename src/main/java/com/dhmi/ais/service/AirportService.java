package com.dhmi.ais.service;

import com.dhmi.ais.domain.entity.Airport;
import org.springframework.http.ResponseEntity;

public interface AirportService {

    ResponseEntity<?> create(Airport airport);
    ResponseEntity<?> deleteById(Long id);
    ResponseEntity<?> getById(Long id);
    ResponseEntity<?> getAll();
    ResponseEntity<?> getByName(String name);
}
