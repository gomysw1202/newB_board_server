package com.board.newb_board_server.service;

import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.mapper.UserMapper;
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
    public UserDTO insertUser(UserDTO dto) {
        var user = UserDTO.builder()
                .userid(dto.getUserid())
                .passwd(passwordEncoder.encode(dto.getPasswd()))
                .email(dto.getEmail())
                .build();
        int result = userMapper.insertUser(user);
        return UserDTO.builder()
                .build();
    }

    public UserDTO authenticate(UserDTO dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserid(),dto.getPasswd()));
        dto = userMapper.getUserDetails(dto.getUserid())
                .orElseThrow();
        return UserDTO.builder()
                .build();
    }

}
