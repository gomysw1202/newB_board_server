package com.board.newb_board_server.dto;


import lombok.*;

@Data
public class BoardDTO {

    private int boardNum;
    private String fkUserid;
    private String title;
    private String content;
    private String writeDate;
    private int views;
    private String  del;
    private String open;

    // 댓글 수를 가져오기 위한 것
    private int commentCnt;


}





