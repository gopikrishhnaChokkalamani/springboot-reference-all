package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis/message")
public class RedisMessageController {

  @Autowired
  private RedisSender sender;

  @GetMapping
  public String sendDataToRedisQueue(@RequestParam("redis") String input) {
    sender.send(input);
    return "successfully sent";
  }
}
