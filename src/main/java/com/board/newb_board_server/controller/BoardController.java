package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.BoardDTO;
import com.board.newb_board_server.dto.UserDTO;
import com.board.newb_board_server.service.BoardService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<List<BoardDTO>> getBoardList(@AuthenticationPrincipal UserDTO dto) {

        String fkUserid = dto.getUserid();

        log.info("여기는 보드 리스트 입니다~!@!~!@~!@~!@~!@~!$#~!" +fkUserid);
        return ResponseEntity.ok().body(boardService.getBoardList(fkUserid));
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

}
