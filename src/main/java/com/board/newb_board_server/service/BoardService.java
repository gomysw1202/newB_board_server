package com.board.newb_board_server.service;

import com.board.newb_board_server.dto.BoardDTO;
import com.board.newb_board_server.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;
    // 게시물 리스트 가져오기
    public List<BoardDTO> getBoardList(String userid) {
        return boardMapper.getBoardList(userid);
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

    // 글 삭제(DEL 컬럼 값을 Y로 변경)
    public int setDelYN(String boardNum) {
        return boardMapper.setDelYN(boardNum);
    }


    public int openCloseContent(Map<String, String> map) {
        return boardMapper.openCloseContent(map);
    }
}
