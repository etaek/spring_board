package com.euntaek.spring_board.dto;

import com.euntaek.spring_board.domain.Board;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;

    public Board toEntity(){
        return Board.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();

    }
    @Builder
    public BoardDto(Long id,String title,String content,String writer){
        this.id=id;
        this.writer=writer;
        this.title=title;
        this.content=content;
    }
}
