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
    // 게시물 리스트 가져오기
    public List<BoardDTO> getBoardList() {
        return boardMapper.getBoardList();
    }

    // 게시글 상세 글 가져오기
    public BoardDTO getBoardDetail(String data) {
        boardMapper.updateViews(data); // 조회수 증가
        return boardMapper.getBoardDetail(data);

    }

    // 글 등록
    public int insertBoard(BoardDTO dto) {
        return boardMapper.insertBoard(dto);
    }

    public int modiftyBoard(BoardDTO dto) {
        return boardMapper.modifyBoard(dto);
    }

    // 글 삭제
    public int deleteBoard(String data) {
        return boardMapper.deleteBoard(data);
    }
}
