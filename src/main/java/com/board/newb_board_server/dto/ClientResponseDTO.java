package com.board.newb_board_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ClientResponseDTO {
    private int codeNo;
    private boolean success;
    private String message;
    private String method;
    private String uri;
}
