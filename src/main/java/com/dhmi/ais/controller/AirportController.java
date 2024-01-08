package com.dhmi.ais.controller;

import com.dhmi.ais.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;
}
