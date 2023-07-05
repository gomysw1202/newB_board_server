package com.board.newb_board_server.controller;

import com.board.newb_board_server.auth.AuthenticationRequest;
import com.board.newb_board_server.auth.AuthenticationResponse;
import com.board.newb_board_server.auth.RegisterRequest;
import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class AuthorizationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody RegisterRequest request){
            return ResponseEntity.ok(authenticationService.insertUser(request));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(@AuthenticationPrincipal UserDTO dto){
        return ResponseEntity.ok("HELLO");

    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request, response);
    }

}