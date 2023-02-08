package com.springboot.test.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "product")
@ToString
public class Product {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long number;
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private Integer stock;
  
  @Column(nullable = false)
  private Integer price;
  
  private LocalDateTime createdAt;
  
  private LocalDateTime updatedAt;
  
}
