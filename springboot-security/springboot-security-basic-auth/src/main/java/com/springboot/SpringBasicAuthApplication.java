package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBasicAuthApplication {

  //even if u have not added any configurations or any customizations
  //just adding the spring security in the pom.xml will enable the login screen when u access the end point
  public static void main(String[] args) {
    SpringApplication.run(SpringBasicAuthApplication.class, args);
  }
}