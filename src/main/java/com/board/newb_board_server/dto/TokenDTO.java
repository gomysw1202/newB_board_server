package com.board.newb_board_server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    public String fkUserid;

    public String token;

    public String tokenType;

    public boolean revoked;

    public boolean expired;

}
