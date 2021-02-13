package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
  
  @Autowired
  private Producer producer;
  
//  @GetMapping("/{message}")
//  public void messageToTopic(@PathVariable(value = "message") String message) {
//    producer.sendMessage(message);
//  }
  
  @PostMapping
  public void messageToStudentTopic(@RequestBody Student student) throws ExecutionException, InterruptedException {
    producer.sendMessageAboutStudent(student);
  }
}
