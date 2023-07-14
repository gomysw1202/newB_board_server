package com.board.newb_board_server.mapper;

import com.board.newb_board_server.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

@Mapper
public interface UserMapper {
    // userid로 user 존재유무 확인하기
    boolean idDuplicateCheck(String userid);

    // 회원가입시 정보 입력하기
    UserDTO insertUser(UserDTO dto);

    // 유저 정보 가져오기
    Optional<UserDTO> getUserDetails(String userid);

}
