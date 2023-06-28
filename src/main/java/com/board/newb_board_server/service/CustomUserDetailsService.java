//package com.board.newb_board_server.service;
//
//import com.board.newb_board_server.dto.UserDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    private final UserService userService;
//
//    @Autowired
//    public CustomUserDetailsService(UserService userService) {
//        this.userService = userService;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
//
//        UserDTO user = userService.getUserDetails(userid).orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));
//
//        return User.builder()
//                .username(user.getUserid())
//                .password(user.getPasswd())
//                .build();
//    }
//
//}