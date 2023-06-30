package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.BoardDTO;
import com.board.newb_board_server.dto.CommentDTO;
import com.board.newb_board_server.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private final CommentService commentService;

    @GetMapping("/list/{fkBoardNum}")
    public ResponseEntity<List<CommentDTO>> getCommentList(@PathVariable("fkBoardNum") String data) {
        log.info("mappingPath fkBoardNum={}", data);
        return ResponseEntity.ok().body(commentService.getCommentList(data));
    }

    @PostMapping("/write")
    public ResponseEntity<?> insertComment (@RequestBody CommentDTO dto) {
        return ResponseEntity.ok().body(commentService.insertComment(dto));
    }

    @PatchMapping("/modify")
    public ResponseEntity<?> modifyComment(@RequestBody CommentDTO dto) {
        return ResponseEntity.ok().body(commentService.modifyComment(dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteComment (@RequestParam String data) {
        return ResponseEntity.ok().body(commentService.deleteComment(data));
    }
}
