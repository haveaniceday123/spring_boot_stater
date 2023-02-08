package com.springboot.test.data.dto;


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
    
    public ProductResponseDtoBuilder name(String name) {
      this.name = name;
      return this;
    }
    
    public ProductResponseDtoBuilder price(int price) {
      this.price = price;
      return this;
    }
    
    public ProductResponseDtoBuilder stock(int stock) {
      this.stock = stock;
      return this;
    }
    
    public ProductResponseDto build() {
      return new ProductResponseDto(number, name, price, stock);
    }
    
    public String toString() {
      return "ProductResponseDto.ProductResponseDtoBuilder(number=" + this.number + ", name=" + this.name + ", price="
        + this.price + ", stock=" + this.stock + ")";
    }
    
    
  }
  
}
