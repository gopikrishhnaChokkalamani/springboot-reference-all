package com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/spring/v1")
public class ActuatorController {

  @Value("${spring.example.actuator.property:defaultvalue}")
  private String value;

  @GetMapping
  public String get() {
    log.debug("Debug Message");
    log.trace("Trace Message");
    log.info("Info Message");
    log.error("Error Message");
    log.warn("Warn Message");
    return "Welcome, To actuator demo!, " + value;
  }
}
