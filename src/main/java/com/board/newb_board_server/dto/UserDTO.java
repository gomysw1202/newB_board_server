package com.board.newb_board_server.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO{

        private String userid;
        private String passwd;
        private String email;
        private String joinDate;
        private String del;

}
