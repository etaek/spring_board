package com.euntaek.spring_board.controller;

import com.euntaek.spring_board.domain.Board;
import com.euntaek.spring_board.dto.BoardDto;
import com.euntaek.spring_board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
    public BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String list(){
        System.out.println("hi");
        return "board/list";
    }

    @GetMapping("/post")
    public String write(){
        return "board/write";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

}
