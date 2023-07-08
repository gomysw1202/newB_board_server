package com.board.newb_board_server.dto;

import lombok.*;

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
