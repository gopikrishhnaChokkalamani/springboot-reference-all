package springboot.redis.messaging;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import springboot.Student;

@MessagingGateway
public interface RedisIntegrationGateway<T> {

  @Gateway(requestChannel = "redis-integration.request.channel")
  Student send(Student request);
}
