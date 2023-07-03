package com.board.newb_board_server.service;

import com.board.newb_board_server.dto.CommentDTO;
import com.board.newb_board_server.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentMapper commentMapper;

    public List<CommentDTO> getCommentList(String fkBoardNum) {
        return commentMapper.getCommentList(fkBoardNum);
    }

    public List<CommentDTO> getCommentListByFkUserid(String fkUserid) {
        return commentMapper.getCommentListByFkUserid(fkUserid);
    }

    public int insertComment(CommentDTO dto) {
        return commentMapper.insertComment(dto);
    }

    public int setDelYN(int commentNum) {
        return commentMapper.setDelYN(commentNum);
    }

    public int modifyComment(CommentDTO dto) {
        return commentMapper.modifyComment(dto);
    }


    public int updateOpenYN(int commentNum) { return commentMapper.updateOpenYN(commentNum); }
}
