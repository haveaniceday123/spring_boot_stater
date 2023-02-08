package com.springboot.test.data.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {
  private String name;
  private int price;
  private int stock;
}
