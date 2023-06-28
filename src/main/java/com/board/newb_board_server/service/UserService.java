package com.board.newb_board_server.service;

import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public boolean isExistUserid(String userid) {
        boolean result = userMapper.isExistUserid(userid);
        return userMapper.isExistUserid(userid);
    }

    public int insertUser(UserDTO dto) {
        dto = dto.EncodePasswd(passwordEncoder);

        return userMapper.insertUser(dto);
    }

    public Optional<UserDTO> getUserDetails(String userid) {

        return userMapper.getUserDetails(userid);
    }
}
