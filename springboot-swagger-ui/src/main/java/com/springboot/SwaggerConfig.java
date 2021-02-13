package com.springboot;

import com.google.common.base.Predicates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  // to access http://localhost:9193/swagger-ui.html
  @Bean
  public Docket docket() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Employee Profile API")
            .description("This API can be used to get profile level actions and information for an Employee")
            .version("V1.0").build();
  }

  //this is useful when u need to configure multiple specs
  @Primary
  @Bean
  public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider defaultResourcesProvider) {
    return () -> {
      SwaggerResource wsResource = new SwaggerResource();
      wsResource.setName("ws endpoints");
      wsResource.setSwaggerVersion("2.0");
      wsResource.setLocation("/v2/websockets.json");

      List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
      resources.add(wsResource);
      return resources;
    };
  }
}