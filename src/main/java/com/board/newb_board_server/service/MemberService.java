package com.board.newb_board_server.service;

import com.board.newb_board_server.dto.MemberDTO;
import com.board.newb_board_server.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

//    @Autowired
    private final MemberMapper memberMapper;
    public int signUp(MemberDTO dto) {
        return memberMapper.insertMember(dto);}


    public Optional<MemberDTO> getMember(String insertedUserid) {

        return memberMapper.selectMember(insertedUserid);
    }

    public boolean isValidMember(String userid, String password) {
        Optional<MemberDTO> member = getMember(userid);
        if (member.isPresent()) {
            return member.get().getPasswd().equals(password);
        }
        return false;
    }
}
