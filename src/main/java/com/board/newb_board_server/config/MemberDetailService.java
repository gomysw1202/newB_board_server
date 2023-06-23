package com.board.newb_board_server.config;

import com.board.newb_board_server.dto.MemberDTO;
import com.board.newb_board_server.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class MemberDetailService implements UserDetailsService {

    private final MemberService memberService;

    public MemberDetailService(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public UserDetails loadUserByUsername(String insertedUserid) throws UsernameNotFoundException {

        log.info("aksgpjioajgiongoqnjgonqogioqgiqjigjqogjqiojgioqgjiqegnjdnvjdap");

        Optional<MemberDTO> getMember = memberService.getMember(insertedUserid);
        MemberDTO member = getMember.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));


        return User.builder()
                .username(member.getUserid())
                .password(member.getPasswd())
                .build();
    }
}
