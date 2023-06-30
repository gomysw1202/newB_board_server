package com.board.newb_board_server.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class UserDTO {

        private String userid;
        private String passwd;
        private String email;
        private String joinDate;
        private String del;

        public UserDTO() {
        }

        public UserDTO(String userid, String passwd, String email, String joinDate, String del) {
            this.userid = userid;
            this.passwd = passwd;
            this.email = email;
            this.joinDate = joinDate;
            this.del = del;
        }

//        public UserDTO EncodePasswd(PasswordEncoder passwordEncoder) {
//            this.passwd = passwordEncoder.encode(this.passwd);
//            return this;
//        }

}
