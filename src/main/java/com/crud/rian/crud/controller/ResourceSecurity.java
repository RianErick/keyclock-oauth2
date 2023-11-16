package com.crud.rian.crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ResourceSecurity {
    @GetMapping
    public ResponseEntity auth(){
        return ResponseEntity.ok().build();
    }
}

