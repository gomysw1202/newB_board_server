package com.board.newb_board_server.dto;

import lombok.*;
import org.apache.ibatis.annotations.Mapper;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private int commentNum; // 댓글번호
    private int fkBoardNum; // 해당 게시물 번호
    private String content; // 댓글 내용
    private int fkCommentNum; // 원댓글
    private String fkUserid; // 작성자
    private String writeDate; // 작성일자
    private int open;
    private int commentLevel; // 댓글(0) 대댓글(1)
    private String del; // 삭제(Y) 미삭제(N)

}
