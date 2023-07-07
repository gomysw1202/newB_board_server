package com.board.newb_board_server.controller;

import com.board.newb_board_server.auth.AuthenticationRequest;
import com.board.newb_board_server.auth.AuthenticationResponse;
import com.board.newb_board_server.auth.RegisterRequest;
import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.insertUser(request));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }




    @GetMapping("/login")
    public String login(){
        log.info("여기는 겟 매핑 입니다" );
        return "dd";
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request, response);
    }




}
