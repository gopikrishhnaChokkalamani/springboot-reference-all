package com.springboot;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/hystrix/client")
@Slf4j
public class HystrixClientController {

    @Autowired
    private HystrixClientService hystrixClientService;

  @GetMapping
  public String fetch() {
    String s = "";
    int i = 0;
    while (i < 100) {
      s = hystrixClientService.serviceFetch();
      System.out.println("COUNTER ######### " + i);
      i++;
    }
    return s;
  }

}
