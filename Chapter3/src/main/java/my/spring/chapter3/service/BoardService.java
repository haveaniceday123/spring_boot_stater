package my.spring.chapter3.service;

import my.spring.chapter3.BoardVO;

import java.util.List;

public interface BoardService {
  
  String hello(String name);
  
  BoardVO getBoard();
  
  List<BoardVO> getBoardList();
  
}
