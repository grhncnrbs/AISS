package com.dhmi.ais.controller;

import com.dhmi.ais.domain.dto.LoginRequestDto;
import com.dhmi.ais.domain.dto.LoginResponseDto;
import com.dhmi.ais.domain.dto.UserResponseDto;
import com.dhmi.ais.security.service.AuthenticationService;
import com.dhmi.ais.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    UserService userService;


    @GetMapping
    public String loginPage() {
        return "loginPage";
    }


    /*@PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticateUser(@Valid @RequestBody LoginRequestDto loginRequest) {
        return authenticationService.authenticateLoginRequest(loginRequest);
    }*/

    @GetMapping("/main")
    public String mainPage() {
        return "mainPage";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginRequestDto") LoginRequestDto loginRequestDto) {
       authenticationService.authenticateLoginRequest(loginRequestDto);
        return "mainPage";
    }
}
