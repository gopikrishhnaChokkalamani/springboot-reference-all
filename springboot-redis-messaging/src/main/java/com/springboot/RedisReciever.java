package com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisReciever implements MessageListener {

  //note no topic based listener like kafka, default message listener
  //so its monotonous, care should be taken scenario to use this
  @Override
  public void onMessage(Message message, byte[] pattern) {
    // TODO Auto-generated method stub
    //log.debug();
    System.out.println("Received data - " + message.toString() + " from Topic - " + new String(pattern));
  }
}
