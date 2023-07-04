package com.board.newb_board_server.service;

import com.board.newb_board_server.auth.AuthenticationRequest;
import com.board.newb_board_server.auth.AuthenticationResponse;
import com.board.newb_board_server.auth.RegisterRequest;
import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.mapper.UserMapper;
import com.board.newb_board_server.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public AuthenticationResponse insertUser(RegisterRequest request) {
        var user = UserDTO.builder()
                .userid(request.getUserid())
                .passwd(passwordEncoder.encode(request.getPasswd()))
                .email(request.getEmail())
                .build();
        userMapper.insertUser(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserid(),request.getPasswd()));
        var user = userMapper.getUserDetails(request.getUserid())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}
