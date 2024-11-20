package com.techforb.challengemonitoreotechforbjava.controller;

import com.techforb.challengemonitoreotechforbjava.dto.CreateUserDto;
import com.techforb.challengemonitoreotechforbjava.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping()
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        Map<String, Object> response = Map.of("data", userService.createUser(createUserDto));

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
