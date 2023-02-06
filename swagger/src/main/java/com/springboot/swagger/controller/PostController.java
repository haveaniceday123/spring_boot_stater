package com.springboot.swagger.controller;

import com.springboot.swagger.dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
  
  @PostMapping(value = "/member")
  public String postMember(@RequestBody Map<String, Object> postData) {
    StringBuilder sb = new StringBuilder();
    
    postData.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
    
    return sb.toString();
  }
  
  @PostMapping(value = "/member2")
  public MemberDto postMemer2(@RequestBody MemberDto member) {
    return member;
  }
  
}
