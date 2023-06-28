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
    // 게시글 상세 글 가지고 오기
    public BoardDTO getBoardDetail(String data) {
        return boardMapper.getBoardDetail(data);
    }

    public List<BoardDTO> getBoardList() {
        return boardMapper.getBoardList();
    }

    // 글 등록
    public int insertBoard(BoardDTO dto) {
        return boardMapper.insertBoard(dto);
    }

    public int modiftyBoard(String data) {
        return boardMapper.modifyBoard(data);
    }
}
