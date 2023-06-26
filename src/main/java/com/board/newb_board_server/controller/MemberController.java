package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.MemberDTO;
import com.board.newb_board_server.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

//    @GetMapping("signUp")
//    public String signUp() {
//        return "login";
//    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody MemberDTO dto){
        try{
            memberService.signUp(dto);
            return ResponseEntity.ok("회원가입 성공");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDTO dto) {
        return ResponseEntity.ok(memberService.getMember(dto.getUserid()));
    }

    @GetMapping("/Main")
    public String main() {
        return "";
    }

}