package com.board.newb_board_server.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class SingleDataResponseDTO<T> extends ClientResponseDTO {
    private int cnt;
    private T items;

    @Builder
    private SingleDataResponseDTO(int codeNo, boolean success, String message, String method, String uri, int cnt, T items) {
        super(codeNo, success, message, method, uri);
        this.cnt = cnt;
        this.items = items;
    }
}
