package com.devtam.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController("/admin")
public class AdminController {
    @GetMapping("/test1")
    public ResponseEntity<?> test1() {
        return ResponseEntity.ok("test1");
    }

    @GetMapping("/test2")
    public ResponseEntity<?> test2() {
        return ResponseEntity.ok("test2");
    }

}
