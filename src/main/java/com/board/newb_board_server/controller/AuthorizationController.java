package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class AuthorizationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody UserDTO dto){
            return ResponseEntity.ok(authenticationService.insertUser(dto));
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("HELLO");

    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(authenticationService.authenticate(dto));
    }


//    @PostMapping("/logout")
//    public ResponseEntity<?> logout() {
//        return ResponseEntity.ok(authenticationService.authenticate(dto));
//    }


}