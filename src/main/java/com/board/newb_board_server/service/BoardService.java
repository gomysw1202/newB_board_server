package com.board.newb_board_server.service;

import com.board.newb_board_server.dto.BoardDTO;
import com.board.newb_board_server.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<BoardDTO> getBoardList() {
        return boardMapper.getBoardList();
    }


}
