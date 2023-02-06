package my.spring.chapter5.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@Entity
public class Board {
  @Id @GeneratedValue
  private String title;
  private String writer;
  private String content;
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date crateDate;
  private Long cnt;
  
}
