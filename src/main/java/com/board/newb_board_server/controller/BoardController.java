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
import java.util.Map;


@Slf4j
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<List<BoardDTO>> getBoardList(@RequestParam String userid) {
        return ResponseEntity.ok().body(boardService.getBoardList(userid));
    }


    @GetMapping("/{boardNum}")
    public ResponseEntity<BoardDTO> getBoardDetail (@PathVariable("boardNum") String data) {
        return ResponseEntity.ok().body(boardService.getBoardDetail(data));
    }


    @PostMapping("/write")
    public ResponseEntity<?> insertBoard (@RequestBody BoardDTO dto) {
        return ResponseEntity.ok().body(boardService.insertBoard(dto));
    }


    @PatchMapping("/modify")
    public ResponseEntity<?> modifyBoard(@RequestBody BoardDTO dto) {
        return ResponseEntity.ok().body(boardService.modiftyBoard(dto));
    }

    @PatchMapping("/delete/{boardNum}")
    public ResponseEntity<?> deleteBoard (@PathVariable("boardNum") String boardNum) {
        return ResponseEntity.ok().body(boardService.setDelYN(boardNum));
    }

    @PostMapping("/openClose")
    public ResponseEntity<?> openCloseContent (@RequestBody Map<String, String> data ) {
        log.info(data.get("open"),data.get("boardNum") );
        return ResponseEntity.ok().body(boardService.openCloseContent(data));
    }


}
