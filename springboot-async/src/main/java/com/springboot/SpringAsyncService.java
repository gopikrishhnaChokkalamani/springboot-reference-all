package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class SpringAsyncService {

  @Autowired
  private KafkaProducer kafkaProducer;

  public void sendMessage(Student student) throws ExecutionException, InterruptedException {
    kafkaProducer.send(student);
  }
}
