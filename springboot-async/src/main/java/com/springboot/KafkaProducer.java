package com.springboot;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaProducer {

  private static final String STUDENT_TOPIC = "kafka-student-topic";

  @Autowired
  private KafkaTemplate kafkaTemplate;

  //Async will not work
  //if the class is not a spring bean
  // if the method is private
  // dont have the caller and the async method in the same class
  //caller will bypass theproy and will call the method directly
  //no thread will be spawned in this case

  //if there is only one threadPoolTaskExecutor in config, @Async will auto recognize
  //if you have multiple then it will create a default executor and run this method
  //so always better to give the threadpool qualifier name in the @async
  @Async("threadPoolTaskExecutorAnother")
  public void send(Student student) throws ExecutionException, InterruptedException {
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

  //using both @Async and CompletableFuture.runAsync() is not correct
  //CompletableFuture.runAsync{ new Runnable ()...} will spawn new thread out of your threadPoolTaskExecutor -> this is wrong;
//  Your application is managed by the container. Since it's discouraged to spawn Threads on you own (CompletableFuture.runAsync()),
//  you can let the container inject a managed Executor.

  //but you can do make the method return CompletableFuture<Student> and annotation @Async
  //and do return CompletableFuture.completedFuture(...);

  //@Async("threadPoolTaskExecutor")
  public void sendMessage(Student student) {
    CompletableFuture.runAsync(() -> {
      try {
        send(student);
      } catch (ExecutionException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
  }
}
