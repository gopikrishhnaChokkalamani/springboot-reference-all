package com.springboot;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "kafka-student-topic", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
//@KafkaListener(topics = {"kafka-student-topic", "kafka-topic"}, groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
public class Consumer {

  @KafkaHandler(isDefault = true)
  public void consumeMessage(@Payload(required = false) Object obj, @Headers MessageHeaders messageHeaders) {
    System.out.println("Invalid data - recieved!!!");
  }
  
  @KafkaHandler
  public void consumeStudentMessage(@Payload Student student, @Header(value = "custom-header-student") String header,
                                    @Headers MessageHeaders messageHeaders) {
    System.out.println("printing from consumer " + ", Header :: " + header + ", payload :: " + student.toString() + " :: "
        + messageHeaders.toString());
  }
}