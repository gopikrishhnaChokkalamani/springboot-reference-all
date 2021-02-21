package com.springboot;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class IntegrationService {

  @ServiceActivator(inputChannel = "integration.gateway.channel")
  public void anotherMessage(Message<String> message) throws InterruptedException {
    MessageChannel reply = (MessageChannel) message.getHeaders().getReplyChannel();
    MessageBuilder.fromMessage(message);
    Message<String> newMessage = MessageBuilder
            .withPayload("Welcome " + message.getPayload() + " to string integration").build();
    Thread.sleep(3000);
    System.out.println("processed Message");
    reply.send(newMessage);
  }
}
