package com.springboot.test.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
  
  @Bean
  public GroupedOpenApi userGroup() {
    return GroupedOpenApi.builder()
      .group("user")
      .addOperationCustomizer(((operation, handlerMethod) -> {
        operation.addSecurityItem(new SecurityRequirement().addList("basicScheme"));
        return operation;
      }))
      .addOpenApiCustomizer(openApi -> openApi.info(new Info().title("Methods").version("v0.1")))
      .packagesToScan("com.springboot.jpa")
      .build();
    
    
  }
}
