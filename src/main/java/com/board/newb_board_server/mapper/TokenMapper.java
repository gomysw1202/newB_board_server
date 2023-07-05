package com.board.newb_board_server.mapper;

import com.board.newb_board_server.dto.TokenDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TokenMapper {

    int save(TokenDTO dto);
    List<TokenDTO> findAllValidTokenByUser(String userid);

    Optional<TokenDTO> findByToken(String token);

    void updateExpiredRevoked(List<TokenDTO> validUserTokens);
}
