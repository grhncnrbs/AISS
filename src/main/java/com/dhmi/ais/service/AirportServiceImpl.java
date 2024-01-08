package com.dhmi.ais.service;

import com.dhmi.ais.domain.dto.ResponseDto;
import com.dhmi.ais.domain.entity.Airport;
import com.dhmi.ais.exception.CustomException;
import com.dhmi.ais.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService{

    @Autowired
    private AirportRepository airportRepository;
    @Override
    public ResponseEntity<?> create(Airport airport) {
        return ResponseEntity.ok(airportRepository.save(airport));
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        Airport airport = airportRepository.findById(id).orElseThrow(() -> new CustomException("Havalimanı bulunamadı. " + id));
        airportRepository.delete(airport);
        return ResponseDto.successResponse("Havalimanı başarıyla silindi.");
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        return ResponseEntity.ok(airportRepository.findById(id));
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(airportRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getByName(String name) {
        return ResponseEntity.ok(airportRepository.findByName(name));
    }
}
