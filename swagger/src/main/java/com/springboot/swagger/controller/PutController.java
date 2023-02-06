package com.springboot.swagger.controller;

import com.springboot.swagger.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/put-api")
public class PutController {
  
  @PutMapping(value = "put")
  public String postMember(@RequestBody Map<String, Object> member) {
    
    StringBuilder sb = new StringBuilder();
    
    member.forEach((key, value) ->
      sb.append(key)
        .append(" : ")
        .append(value)
        .append("\n")
    );
    return sb.toString();
    
  }
  
  @PutMapping(value = "put/test")
  public String postMember2(@RequestBody MemberDto member) {
    return member.toString();
  }
  
  @PutMapping(value = "put/test2")
  public MemberDto postMember3(@RequestBody MemberDto member) {
    return member;
  }
  
  @PutMapping(value = "put/test3")
  public ResponseEntity<MemberDto> postMember4(@RequestBody MemberDto memberDto) {
    return ResponseEntity
      .status(HttpStatus.ACCEPTED)
      .body(memberDto);
  }
  
  
}
