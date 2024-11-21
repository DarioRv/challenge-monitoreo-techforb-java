package com.techforb.challengemonitoreotechforbjava.controller;

import com.techforb.challengemonitoreotechforbjava.dto.Credentials;
import com.techforb.challengemonitoreotechforbjava.service.IAuthtenticationService;
import com.techforb.challengemonitoreotechforbjava.service.impl.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IAuthtenticationService authService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Credentials credentials) {
        Map<String, Object> response = authService.login(credentials);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
