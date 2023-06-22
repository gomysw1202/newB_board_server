package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.MemberDTO;
import com.board.newb_board_server.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(MemberDTO dto) {
        boolean isValidMember = memberService.isValidMember(dto.getUserid(), dto.getPasswd());
        if (isValidMember)
            return "dashboard";
        return "login";
    }
    @PostMapping("/signUp")
    public String signUp(@RequestBody MemberDTO dto) throws IOException {
        log.info("login data" , dto.getPasswd());
        int n = memberService.signUp(dto);


        return "ok";
    }



}
