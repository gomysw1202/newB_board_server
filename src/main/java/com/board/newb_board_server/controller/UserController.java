package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
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


    /*
     * 아이디 중복 체크
     * */
    @GetMapping("/idDuplicateCheck")
    public ResponseEntity<?> idDuplicateCheck(@RequestParam String userid) {
        return ResponseEntity.ok(userService.idDuplicateCheck(userid));
    }


    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserDTO dto){
        return ResponseEntity.ok(userService.signUp(dto));
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }




//    @GetMapping("/login")
//    public ResponseEntity<String> login(){
//        return ResponseEntity.ok("HELLO");
//
//    }




//    @PostMapping("/logout")
//    public ResponseEntity<?> logout() {
//        return ResponseEntity.ok(authenticationService.authenticate(dto));
//    }




//    @GetMapping("/main")
//    public ResponseEntity<String> mainPage(UserDTO dto) {
//        return  ResponseEntity.ok(dto.getUserid());
//    }


//    @PostMapping("/signUp")
//    public ResponseEntity<?> signUp(@RequestBody UserDTO dto){
//        try{
//            userService.insertUser(dto);
//            return ResponseEntity.ok("회원가입 성공");
//        }catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }


}
