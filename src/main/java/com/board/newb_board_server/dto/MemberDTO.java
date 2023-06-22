package com.board.newb_board_server.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDTO {

    private String userid;
    private String passwd;
    private String email;
    private String joinDate;
    private int status;

    public MemberDTO() {
    }

    public MemberDTO(String userid, String passwd, String email, String joinDate, int status) {
        this.userid = userid;
        this.passwd = passwd;
        this.email = email;
        this.joinDate = joinDate;
        this.status = status;
    }
}
