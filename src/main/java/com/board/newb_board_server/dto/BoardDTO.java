package com.board.newb_board_server.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private int boardNum;

    private String fkUserid;
    private String title;
    private String content;
    private String writeDate;
    private int views;
    private int status;
    private int open;


}





