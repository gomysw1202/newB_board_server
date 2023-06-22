package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;


@CrossOrigin(origins ="*", allowedHeaders = "*")
@RestController
@Slf4j
public class BoardController {
//    private final Logger log = LoggerFactory.getLogger(getClass());

//
//    @RequestMapping("/")
//    public String index() {
//
//        return " ";
//    }
//    @RequestMapping("/log-test")
//    public String logTest() {
//        String name = "Spring";
//
//        System.out.println("name = " + name);
//        log.trace(" trace log={}", name);
//        log.debug(" debug log={}", name);
//        log.info("  info log={}", name);
//        log.warn("  warn log={}", name);
//        log.error(" error log={}", name);
//
//        return "ok";
//    }
//
//
//    /*
//    *   PathVariable 경로 변수 사용
//    *   게시판 상세보기 할 때 사용할 것!
//    * */
//    @GetMapping("/board/{boardNum}")
////    public String getBoardDetail (@PathVariable String boardNum) { // 이렇게도 사용가능하다네요 통일 시켜서
//    public String getBoardDetail (@PathVariable("boardNum") String data) {
//        log.info("mappingPath boardNum={}", data);
//        return "나는 이거를 사용해서 상세보기를 만들 수 있을거 같은데요???!??~??!?~!?!~?";
//    }

}
