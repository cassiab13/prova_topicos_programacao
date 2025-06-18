package com.topicosprogramacao.jwt.controllers;

import com.topicosprogramacao.jwt.dtos.AuthRequestDTO;
import com.topicosprogramacao.jwt.dtos.AuthResponseDTO;
import com.topicosprogramacao.jwt.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private AuthService service;

    @PostMapping
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO dto){
        return ResponseEntity.ok(service.login(dto));
    }
}
