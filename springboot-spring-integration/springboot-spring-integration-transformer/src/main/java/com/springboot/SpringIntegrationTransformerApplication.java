package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringIntegrationTransformerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringIntegrationTransformerApplication.class, args);
  }
}
