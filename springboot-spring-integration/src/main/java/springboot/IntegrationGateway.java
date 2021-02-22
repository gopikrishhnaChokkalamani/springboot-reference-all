package springboot;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {

  @Gateway(requestChannel = "integration.gateway.channel")
  public String sendMessage(String message);

  @Gateway(requestChannel = "integration.transformer.channel")
  public String sendMessage(Student student);

  @Gateway(requestChannel = "integration.header-enricher.channel")
  public String headerEnricher(Student student);
}