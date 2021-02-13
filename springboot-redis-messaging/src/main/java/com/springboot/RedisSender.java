package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class RedisSender {

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ChannelTopic topic;

  public void send(String input) {
    redisTemplate.convertAndSend(topic.getTopic(), input);
    System.out.println("Data - " + input + " sent through Redis Topic - " + topic.getTopic());
  }
}