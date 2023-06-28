package com.board.newb_board_server.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class UserDTO {

        @Schema(description = "아이디")
        private String userid;
        @Schema(description = "비밀번호")
        private String passwd;
        @Schema(description = "이메일")
        private String email;
        @Schema(description = "가입날짜")
        private String joinDate;
        @Schema(description = "활성화")
        private int status;

        public UserDTO() {
        }

        public UserDTO(String userid, String passwd, String email, String joinDate, int status) {
            this.userid = userid;
            this.passwd = passwd;
            this.email = email;
            this.joinDate = joinDate;
            this.status = status;
        }

        public UserDTO EncodePasswd(PasswordEncoder passwordEncoder) {
            this.passwd = passwordEncoder.encode(this.passwd);
            return this;
        }

}
