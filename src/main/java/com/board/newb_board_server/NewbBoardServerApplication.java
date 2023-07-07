package com.board.newb_board_server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.board.newb_board_server")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class NewbBoardServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewbBoardServerApplication.class, args);
    }

}
