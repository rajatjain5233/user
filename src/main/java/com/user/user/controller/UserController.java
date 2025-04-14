package com.user.user.controller;

import com.user.user.entity.User;
import com.user.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/test") // Add this endpoint
    public ResponseEntity<String> testConnection() {
        return ResponseEntity.ok("Connection Successful!");
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists!");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }
}