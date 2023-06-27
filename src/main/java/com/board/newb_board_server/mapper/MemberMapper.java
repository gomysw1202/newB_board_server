package com.board.newb_board_server.mapper;

import com.board.newb_board_server.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    // userid로 user 존재유무 확인하기
    boolean isExistUserid(String userid);

    // member 회원가입시 정보 입력하기
    int insertMember(MemberDTO dto);

    // member 정보 가져오기
    Optional<MemberDTO> getMember(String insertedUserId);
}
