package com.board.newb_board_server.service;

import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;


    public boolean idDuplicateCheck(String userid) {
        return userMapper.idDuplicateCheck(userid);
    }

    public int signUp(UserDTO dto) {
//        var user = UserDTO.builder()
//                .userid(dto.getUserid())
//                .passwd(Sha256.encrypt(dto.getPasswd()))
//                .email(dto.getEmail())
//                .build();
        return  userMapper.insertUser(dto);
    }


    public boolean login(UserDTO dto) {
        boolean isExist = userMapper.getUserDetails(dto).isPresent();

        return isExist;
    }


//    public int insertUser(UserDTO dto) {
////        dto = dto.EncodePasswd(passwordEncoder);
//
//        return userMapper.insertUser(dto);
//    }
//
//    public Optional<UserDTO> getUserDetails(String userid) {
//
//        return userMapper.getUserDetails(userid);
//    }








}
