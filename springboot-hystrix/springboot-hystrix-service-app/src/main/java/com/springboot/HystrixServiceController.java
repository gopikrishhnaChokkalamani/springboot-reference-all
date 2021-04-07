package com.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix/service")
public class HystrixServiceController {

  @GetMapping
  public String fetch() throws InterruptedException {
    //Thread.sleep(1000);
    return "Hello from the Service Application";
  }
}
