package com.euntaek.spring_board.service;

import com.euntaek.spring_board.repository.BoardRepository;
import com.euntaek.spring_board.dto.BoardDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }


}
