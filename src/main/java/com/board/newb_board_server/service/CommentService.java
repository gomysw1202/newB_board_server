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

    public List<CommentDTO> getCommentList(String data) {
        return commentMapper.getCommentList(data);
    }


    public int insertComment(CommentDTO dto) {
        return commentMapper.insertComment(dto);
    }

    public int deleteComment(String data) {
        return commentMapper.deleteComment(data);
    }

    public int modifyComment(CommentDTO dto) {
        return commentMapper.modifyComment(dto);
    }
}
