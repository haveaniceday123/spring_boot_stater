package com.springboot.swagger.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/put-api")
public class DeleteController {
  
  @DeleteMapping("/{variable}")
  public String DeleteVariable(@PathVariable String variable) {
    return variable;
  }
  
  @DeleteMapping("/request1")
  public String getRequestParam(@RequestParam String email) {
    return "email : " + email;
  }
  
}
