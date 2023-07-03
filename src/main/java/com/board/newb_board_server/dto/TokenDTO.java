package com.board.newb_board_server.dto;

import com.board.newb_board_server.token.TokenType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    public Integer id;

    public String token;

    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    public UserDTO userid;
}
