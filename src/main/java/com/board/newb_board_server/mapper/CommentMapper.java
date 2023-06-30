package com.board.newb_board_server.mapper;

import com.board.newb_board_server.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    // 게시물에 달린 댓글 가져오기
    List<CommentDTO> getCommentList(String data);

    // 댓글 작성
    int insertComment(CommentDTO dto);


    // 댓글 수정
    int modifyComment(CommentDTO dto);

    // 댓글 삭제
    int deleteComment(String data);
}

