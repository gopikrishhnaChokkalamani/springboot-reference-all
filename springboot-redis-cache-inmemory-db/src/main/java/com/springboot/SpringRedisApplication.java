package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCaching
public class SpringRedisApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringRedisApplication.class, args);
  }
}