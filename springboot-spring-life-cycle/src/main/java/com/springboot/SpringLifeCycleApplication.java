package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringLifeCycleApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(SpringLifeCycleApplication.class, args);
    context.addApplicationListener(event -> System.out.println("Application listener Event"));
  }
}