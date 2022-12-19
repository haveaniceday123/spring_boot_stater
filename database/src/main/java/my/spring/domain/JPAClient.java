package my.spring.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Date;

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
      board.setContent("JPA글 등록 잘 되네요");
      board.setCreateDate(new Date());
      board.setCnt(0L);

      em.persist(board);
      tx.commit();

    } catch (Exception e) {
      e.printStackTrace();
      tx.rollback();
    } finally {
      em.close();
      emf.close();
    }
  }
}
