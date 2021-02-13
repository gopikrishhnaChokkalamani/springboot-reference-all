package com.springboot;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class Producer {
  
  private static final String STRING_TOPIC = "kafka-topic";
  
  private static final String STUDENT_TOPIC = "kafka-student-topic";
  
  @Autowired
  private KafkaTemplate kafkaTemplate;

//  public void sendMessage(String message) {
//    this.kafkaTemplate.send("kafka-topic", message);
//  }
  
  public void sendMessageAboutStudent(Student student) throws ExecutionException, InterruptedException {
    Message<Student> message = MessageBuilder.withPayload(student).setHeader(KafkaHeaders.TOPIC, STUDENT_TOPIC)
        .setHeader("custom-header-student", STUDENT_TOPIC).build();
    
    Map<String, Object> headers = new HashMap<>();
    headers.put(KafkaHeaders.TOPIC, STUDENT_TOPIC);
    headers.put("custom-header-student", STUDENT_TOPIC);
    //ListenableFuture<SendResult<String, Student>> sendResult = kafkaTemplate.send(new GenericMessage<Student>(student, headers));
    ListenableFuture<SendResult<String, Student>> sendResult = kafkaTemplate.send(message);
    SendResult<String, Student> result = sendResult.get();
    if (result != null) {
      RecordMetadata metadata = result.getRecordMetadata(); //get metadata info from the result
      ProducerRecord<String, Student> producerRecord = result.getProducerRecord(); // get all headers, payload, topic info
      if (metadata != null) {
        System.out.println("offset :: " + metadata.offset() + ", partition :: " + metadata.partition() + ", timestamp :: " + metadata.timestamp());
      }
    }
  }

//  @Bean
//  public NewTopic stringTopic() {
//    return new NewTopic(STRING_TOPIC, 3, (short) 1);
//  }
}
