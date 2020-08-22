package com.euntaek.spring_board.service;

import com.euntaek.spring_board.domain.Board;
import com.euntaek.spring_board.repository.BoardRepository;
import com.euntaek.spring_board.dto.BoardDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public List<BoardDto> getBoardlist(){
        List<Board>boards=boardRepository.findAll();
        List<BoardDto>boardDtoList=new ArrayList<>();

        for(Board board : boards){
            BoardDto boardDto=BoardDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer((board.getWriter()))
                    .build();
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }
    @Transactional
    public BoardDto getPost(Long id){
        Optional<Board> boardWrapper=boardRepository.findById(id);
        Board board=boardWrapper.get();

        BoardDto boardDto=BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .build();
        return boardDto;
    }

}
