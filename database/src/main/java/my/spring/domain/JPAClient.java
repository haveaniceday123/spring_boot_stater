package my.spring.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class JPAClient {
  public static void main(String[] args) {

    EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("database");

    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();


    try {
      
      tx.begin();
      
      Board board = new Board();
      board.setTitle("JPA 제목");
      board.setWriter("관리자");
      board.setContent("JPA글 등록 잘 되네요!!");
      board.setCreateDate(new Date());
      board.setCnt(0L);
      
      em.persist(board);
//      tx.commit();
//      tx.begin();
      
      String jpql = "select b from Board b order by b.seq desc";
      List<Board> boardList =
        em.createQuery(jpql, Board.class).getResultList();
      Thread.sleep(100000);
  
      for (Board brd : boardList) {
        System.out.println("--> " + brd.toString());
      }
      tx.commit();
//      Board searchBoard = em.find(Board.class, 1L);
//      System.out.println("---> " + searchBoard.toString());
      
    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
    } finally {
      em.close();
      emf.close();
    }
   
  }
}
