package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.BoardDTO;
import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<List<BoardDTO>> getBoardList() {
//        List<BoardDTO> boardList = boardService.getBoardList();

        return ResponseEntity.ok().body(boardService.getBoardList());
    }

    /*
    *   PathVariable 경로 변수 사용
    *   게시판 상세보기 할 때 사용할 것!
    * */
    @GetMapping("/{boardNum}")
//    public String getBoardDetail (@PathVariable String boardNum) { // 이렇게도 사용가능하다네요 통일 시켜서
    public ResponseEntity<BoardDTO> getBoardDetail (@PathVariable("boardNum") String data) {
        log.info("mappingPath boardNum={}", data);

        return ResponseEntity.ok().body(boardService.getBoardDetail(data));
    }



//    @PutMapping("/write/{boardNum}")
//    public ResponseEntity<?> modifyBoard(@PathVariable("boardNum") String data) {
//        return ResponseEntity.ok().body(boardService.modiftyBoard(data));
//    }




    @PostMapping("/write")
    public ResponseEntity<?> insertBoard (@RequestBody BoardDTO dto) {
        return ResponseEntity.ok().body(boardService.insertBoard(dto));
    }



}
