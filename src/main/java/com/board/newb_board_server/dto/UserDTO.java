package com.board.newb_board_server.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements UserDetails {

        private String userid;
        private String passwd;
        private String email;
        private String joinDate;
        private String del;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
        }

        @Override
        public String getPassword() {
                return passwd;
        }

        @Override
        public String getUsername() {
                return userid;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }


//        public UserDTO EncodePasswd(PasswordEncoder passwordEncoder) {
//            this.passwd = passwordEncoder.encode(this.passwd);
//            return this;
//        }

}
