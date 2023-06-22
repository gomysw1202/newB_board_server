package com.board.newb_board_server.dto;


import lombok.Data;

@Data
public class BoardDTO {
    private String userid;
    private String passwd;
    private String email;
    private String join_date;
    private Integer status;
}

