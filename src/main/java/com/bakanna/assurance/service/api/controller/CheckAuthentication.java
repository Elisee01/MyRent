package com.bakanna.assurance.service.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckAuthentication {

    @GetMapping("/check")
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("Hello from Secured URL");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello from Admin");
    }
}
