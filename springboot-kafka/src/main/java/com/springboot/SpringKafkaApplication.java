package com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringKafkaApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(SpringKafkaApplication.class, args);
  }
}
