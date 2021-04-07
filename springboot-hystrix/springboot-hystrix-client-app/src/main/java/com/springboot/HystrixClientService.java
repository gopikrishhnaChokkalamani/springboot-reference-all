package com.springboot;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class HystrixClientService {

  private RestTemplate restTemplate;

  @Autowired
  public HystrixClientService(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
  }

  //to enable hystrix command you have to call it from another bean, in this case from controller
  //if you put these two methods in the controller itself, it will not work
  @HystrixCommand(groupKey = "clientapp", commandKey = "fetchService", fallbackMethod = "defaultFetch")
  public String serviceFetch() {
      return restTemplate.getForObject("http://localhost:9189/hystrix/service", String.class);
  }

  public String defaultFetch() {
    log.error("Hystric Fallback is executing ::: error ");
    System.out.println("In defaultFetch");
    return "Hystric Fallback Occurred";
  }
}
