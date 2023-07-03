package com.board.newb_board_server.service;


import com.board.newb_board_server.auth.AuthenticationRequest;
import com.board.newb_board_server.auth.AuthenticationResponse;
import com.board.newb_board_server.dto.TokenDTO;
import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.mapper.TokenMapper;
import com.board.newb_board_server.mapper.UserMapper;
import com.board.newb_board_server.security.JwtService;
import com.board.newb_board_server.token.TokenType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserMapper userMapper;
    private final TokenMapper tokenMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse insertUser(UserDTO dto) {
        var user = UserDTO.builder()
                .userid(dto.getUserid())
                .passwd(passwordEncoder.encode(dto.getPasswd()))
                .email(dto.getEmail())
                .build();
        var insertUser = userMapper.insertUser(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(insertUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserid(),
                        request.getPasswd()
                )
        );
        var user = userMapper.getUserDetails(request.getUserid())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(UserDTO dto, String jwtToken) {
        var token = TokenDTO.builder()
                .userid(dto)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenMapper.save(token);
    }

    private void revokeAllUserTokens(UserDTO dto) {
        var validUserTokens = tokenMapper.findAllValidTokenByUser(dto.getUserid());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenMapper.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userid;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userid = jwtService.extractUsername(refreshToken);
        if (userid != null) {
            var user = this.userMapper.findByUserid(userid)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
