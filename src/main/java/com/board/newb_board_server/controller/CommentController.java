package com.board.newb_board_server.controller;

import com.board.newb_board_server.dto.CommentDTO;
import com.board.newb_board_server.service.CommentService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private final CommentService commentService;

    @GetMapping("/list/{fkBoardNum}")
    public ResponseEntity<List<CommentDTO>> getCommentList(@PathVariable("fkBoardNum") String fkBoardNum) {
        log.info("mappingPath fkBoardNum={}", fkBoardNum);
        return ResponseEntity.ok().body(commentService.getCommentList(fkBoardNum));
    }


    @GetMapping("/list")
    public ResponseEntity<List<CommentDTO>> getCommentListByFkUserid(@RequestParam @Nullable String fkUserid) {
        log.info("mappingPath fkBoardNum={}", fkUserid);
        return ResponseEntity.ok().body(commentService.getCommentListByFkUserid(fkUserid));
    }

    @PostMapping("/write")
    public ResponseEntity<?> insertComment (@RequestBody CommentDTO dto) {
        return ResponseEntity.ok().body(commentService.insertComment(dto));
    }

    @PatchMapping("/modify")
    public ResponseEntity<?> modifyComment(@RequestBody CommentDTO dto) {
        return ResponseEntity.ok().body(commentService.modifyComment(dto));
    }

    @PatchMapping("/delete")
    public ResponseEntity<?> deleteComment (@RequestParam int commentNum) {
        return ResponseEntity.ok().body(commentService.setDelYN(commentNum));
    }

    @PatchMapping("/updateOpenYN")
    public ResponseEntity<?> updateOpenYN(@RequestBody int commentNum) {
        return ResponseEntity.ok().body(commentService.updateOpenYN(commentNum));
    }
}
