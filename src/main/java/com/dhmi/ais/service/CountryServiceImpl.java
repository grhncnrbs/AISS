package com.dhmi.ais.service;

import com.dhmi.ais.domain.entity.Country;
import com.dhmi.ais.exception.CustomException;
import com.dhmi.ais.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CountryServiceImpl implements CountryService{

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public ResponseEntity<?> create(Country country) {
        return ResponseEntity.ok(countryRepository.save(country));
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        Country country = countryRepository.findById(id).orElseThrow(()-> new CustomException("Ülke bulunamadı. " + id));
        countryRepository.deleteById(id);
        LOGGER.info("Silinen ülke: ", country.getName());
        return null;
    }

    @Override
    public ResponseEntity<?> getById(Long id) {
        return ResponseEntity.ok(countryRepository.findById(id));
    }

    @Override
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(countryRepository.findAll());
    }

    @Override
    public ResponseEntity<?> getByName(String name) {
        return ResponseEntity.ok(countryRepository.findByName(name));
    }
}
