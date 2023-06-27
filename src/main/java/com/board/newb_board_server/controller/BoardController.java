package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.BoardDTO;
import com.board.newb_board_server.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;


@Slf4j
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @GetMapping("/boardList")
    public ResponseEntity<List<BoardDTO>> getBoardList() {

        List<BoardDTO> list = boardService.getBoardList();
        return ResponseEntity.ok().body(list);
    }




    /*
    *   PathVariable 경로 변수 사용
    *   게시판 상세보기 할 때 사용할 것!
    * */
//    @GetMapping("/board/{boardNum}")
////    public String getBoardDetail (@PathVariable String boardNum) { // 이렇게도 사용가능하다네요 통일 시켜서
//    public String getBoardDetail (@PathVariable("boardNum") String data) {
//        log.info("mappingPath boardNum={}", data);
//        return "나는 이거를 사용해서 상세보기를 만들 수 있을거 같은데요???!??~??!?~!?!~?";
//    }

}
