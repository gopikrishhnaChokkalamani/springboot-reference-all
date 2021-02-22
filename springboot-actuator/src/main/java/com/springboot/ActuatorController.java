package com.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring/v1")
public class ActuatorController {

  @GetMapping
  public String get() {
    return "Welcome, To actuator demo!";
  }
}
