package com.board.newb_board_server.service;

import com.board.newb_board_server.dto.MemberDTO;
import com.board.newb_board_server.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

//    @Autowired
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;


    public boolean isExistUserid(String userid) {
        boolean result = memberMapper.isExistUserid(userid);
        return memberMapper.isExistUserid(userid);
    }

    public int insertMember(MemberDTO dto) {
        dto = dto.EncodePasswd(passwordEncoder);

        log.info(dto.getPasswd());
        return memberMapper.insertMember(dto);}


//    public Optional<MemberDTO> getMember(String insertedUserid) {
//
//        return memberMapper.getMember(insertedUserid);
//    }

//    public boolean isValidMember(String userid, String password) {
//        Optional<MemberDTO> member = getMember(userid);
//        if (member.isPresent()) {
//            return member.get().getPasswd().equals(password);
//        }
//        return false;
//    }

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        MemberDTO member = memberMapper.getMember(userid).orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return User.builder()
                .username(member.getUserid())
                .password(member.getPasswd())
                .build();
    }
}
