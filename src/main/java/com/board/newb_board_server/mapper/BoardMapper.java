package com.board.newb_board_server.mapper;

import com.board.newb_board_server.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    List<BoardDTO> getBoardList();
}
