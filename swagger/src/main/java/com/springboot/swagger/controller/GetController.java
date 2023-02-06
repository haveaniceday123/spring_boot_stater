package com.springboot.swagger.controller;

import com.springboot.swagger.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
  
  private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);
  
  @GetMapping(value = "/name")
  public String getName() {
    LOGGER.info("getName 메서드가 호출되었습니다.");
    return "Flature";
  }
  
  @GetMapping(value = "/variable/{variable}")
  
  public String getVariable1(@PathVariable String variable) {
    LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
    return variable;
  }
  
  @GetMapping(value = "/variable2/{variable}")
  public String getVariable2(@PathVariable("variable") String var) {
    return var;
  }
  
  @Operation(summary = "Get 메서드 예제", description = "@RequstParam을 활용한 GET Method")
  @GetMapping(value = "/request1")
  public String getRequestParam1(
    @Parameter(name = "name", description = "이름", required = true) @RequestParam String name,
    @Parameter(name = "email", description = "이메일", required = true) @RequestParam String email,
    @Parameter(name = "organization", description = "회사", required = true) @RequestParam String organization
  ) {
    return name + " " + email + " " + organization;
  }
  
  @GetMapping(value = "/request2")
  public String getRequestParam2(
    @RequestParam Map<String, String> param
  ) {
    StringBuilder sb = new StringBuilder();
    param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
    
    return sb.toString();
  }
  
  @GetMapping(value = "/request3")
  public String getRequestParam3(MemberDto member) {
    return member.toString();
  }
  
}
