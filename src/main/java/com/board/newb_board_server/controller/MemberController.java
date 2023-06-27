package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.MemberDTO;
import com.board.newb_board_server.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
@Slf4j
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class MemberController  {

    @Autowired
    private MemberService memberService;

    @PostMapping("/checkIdDuplicate")
    public ResponseEntity<?> checkIdDuplicate(@RequestBody MemberDTO dto) {
        return  ResponseEntity.ok(memberService.isExistUserid(dto.getUserid()));
    }

//    @GetMapping("/signUp")
//    public String signUp() {
//        return "/signUp";
//    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody MemberDTO dto, PasswordEncoder passwordEncoder){
        try{
            memberService.insertMember(dto);
            return ResponseEntity.ok("회원가입 성공");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }






}