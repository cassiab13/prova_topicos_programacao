package com.topicosprogramacao.jwt.services;

import com.topicosprogramacao.jwt.dtos.AuthRequestDTO;
import com.topicosprogramacao.jwt.dtos.AuthResponseDTO;
import com.topicosprogramacao.jwt.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtUtil jwt;

    @Autowired
    private UserService service;

    public AuthResponseDTO login(AuthRequestDTO request){
        Authentication auth = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );
        manager.authenticate(auth);
        UserDetails user = service.loadUserByUsername(request.getEmail());

        String token = jwt.generateToken(user);
        return new AuthResponseDTO(token);
    }
}
