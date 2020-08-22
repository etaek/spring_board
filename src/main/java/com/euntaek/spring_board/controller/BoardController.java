package com.euntaek.spring_board.controller;

import com.euntaek.spring_board.domain.Board;
import com.euntaek.spring_board.dto.BoardDto;
import com.euntaek.spring_board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    public BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String list(Model model){
        List<BoardDto> boardDtoList=boardService.getBoardlist();
        model.addAttribute("boardList",boardDtoList);
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

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no")Long id, Model model){
        BoardDto boardDto=boardService.getPost(id);
        model.addAttribute("boardDto",boardDto);
        return "board/detail";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no")Long id,Model model){
        BoardDto boardDto=boardService.getPost(id);
        model.addAttribute("boardDto",boardDto);
        return"board/update";
    }

    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDto){
        boardService.savePost(boardDto);
        return"redirect:/";
    }
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no")Long id){
        boardService.deletePost(id);
        return"redirect:/";

    }

}
