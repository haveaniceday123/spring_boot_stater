package com.springboot.swagger;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwaggerApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(SwaggerApplication.class, args);
  }
  
  @Bean
  public GroupedOpenApi userGroup() {
    return GroupedOpenApi.builder()
      .group("user")
      .addOperationCustomizer(((operation, handlerMethod) -> {
        operation.addSecurityItem(new SecurityRequirement().addList("basicScheme"));
        return operation;
      }))
      .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Methods").version("v0.1")))
      .packagesToScan("com.springboot.swagger")
      .build();
    
    
  }
  
}
