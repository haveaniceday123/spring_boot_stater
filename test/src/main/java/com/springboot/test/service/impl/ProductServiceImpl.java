package com.springboot.test.service.impl;

import com.springboot.test.data.dto.ProductDto;
import com.springboot.test.data.dto.ProductResponseDto;
import com.springboot.test.data.entity.Product;
import com.springboot.test.service.ProductService;
import com.springboot.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
  
  private final ProductDAO productDAO;
  
  @Autowired
  public ProductServiceImpl(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }
  
  @Override
  public ProductResponseDto getProduct(Long number) {
    Product product = productDAO.selectProduct(number);
    
    ProductResponseDto productResponseDto = new ProductResponseDto();
    productResponseDto.setNumber(product.getNumber());
    productResponseDto.setName(product.getName());
    productResponseDto.setPrice(product.getPrice());
    productResponseDto.setStock(product.getStock());
    return productResponseDto;
  }
  
  @Override
  public ProductResponseDto saveProduct(ProductDto productDto) {
    Product product = new Product();
    product.setName(productDto.getName());
    product.setPrice(productDto.getPrice());
    product.setStock(productDto.getStock());
    product.setCreatedAt(LocalDateTime.now());
    product.setUpdatedAt(LocalDateTime.now());
    
    Product saveProduct = productDAO.insertProduct(product);
  
    return new ProductResponseDto.ProductResponseDtoBuilder()
      .name(saveProduct.getName())
      .number(saveProduct.getNumber())
      .price(saveProduct.getPrice())
      .stock(saveProduct.getStock())
      .build();
  }
  
  @Override
  public ProductResponseDto changeProductName(Long number, String name) throws Exception {
    Product changedProduct = productDAO.updateProductName(number, name);
    return new ProductResponseDto.ProductResponseDtoBuilder()
      .number(changedProduct.getNumber())
      .name(changedProduct.getName())
      .price(changedProduct.getPrice())
      .stock(changedProduct.getStock())
      .build();
  }
  
  @Override
  public void deleteProduct(Long number) throws Exception {
    productDAO.deleteProduct(number);
  }
}
