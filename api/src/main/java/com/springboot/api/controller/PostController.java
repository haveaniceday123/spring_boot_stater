package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

  @RequestMapping(value = "/domain", method = RequestMethod.POST)
  public String postExample() {
    return "HELLO POST API";
  }

  @RequestMapping(value = "/member2")
  public String postMemberDto(@RequestBody MemberDto memberDto) {
    return memberDto.toString();
  }

}
