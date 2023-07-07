package com.board.newb_board_server.mapper;

import com.board.newb_board_server.dto.BoardDTO;
import com.board.newb_board_server.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    List<BoardDTO> getBoardList(String fkUserid);

    BoardDTO getBoardDetail(String data);

    // 글 등록
    int insertBoard(BoardDTO dto);

    // 글 수정
    int modifyBoard(BoardDTO dto);

    // 글 삭제
    int setDelYN(String data);

    int updateViews(String data);


    // 나에게 달린 댓글 조회
    List<BoardDTO> getMyBoardCommentList();

}
