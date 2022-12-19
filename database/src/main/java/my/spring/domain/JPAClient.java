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


    try {
      Board searchBoard = em.find(Board.class, 1L);
      System.out.println("---> " + searchBoard.toString());
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      em.close();
      emf.close();
    }
   
  }
}
