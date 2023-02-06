package com.springboot.jpa.data.dto;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponseDto {
  
  private Long number;
  private String name;
  private int price;
  private int stock;
  
  public static ProductResponseDtoBuilder builder() {
    return new ProductResponseDtoBuilder();
  }
  
  @NoArgsConstructor
  public static class ProductResponseDtoBuilder {
    private Long number;
    private String name;
    private int price;
    private int stock;
    
    public ProductResponseDtoBuilder number(Long number) {
      this.number = number;
      return this;
    }
    
    public
    
    
  }
  
}
