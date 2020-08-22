package com.euntaek.spring_board.repository;


import com.euntaek.spring_board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

}
