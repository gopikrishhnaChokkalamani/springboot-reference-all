package com.springboot;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@MessagingGateway
public interface IntegrationGateway {

  @Gateway(requestChannel = "integration.gateway.channel")
  public String sendMessage(String message);
}
