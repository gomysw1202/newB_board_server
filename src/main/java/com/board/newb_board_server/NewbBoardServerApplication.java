package com.board.newb_board_server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.board.newb_board_server")
public class NewbBoardServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewbBoardServerApplication.class, args);
    }

}
