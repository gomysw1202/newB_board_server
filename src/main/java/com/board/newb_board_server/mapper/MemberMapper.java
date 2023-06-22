package com.board.newb_board_server.mapper;

import com.board.newb_board_server.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    int insertMember(MemberDTO dto);

    Optional<MemberDTO> selectMember(String insertedUserId);
}
