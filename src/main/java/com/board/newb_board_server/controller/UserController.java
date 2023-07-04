package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/checkIdDuplicate")
    public ResponseEntity<?> checkIdDuplicate(@RequestBody UserDTO dto) {
        return  ResponseEntity.ok(userService.isExistUserid(dto.getUserid()));
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserDTO dto){
        try{
            userService.insertUser(dto);
            return ResponseEntity.ok("회원가입 성공");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
