package springboot.redis.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.Student;

@RestController
@RequestMapping("/integration/redis")
public class RedisIntegrationController {

  @Autowired
  private RedisIntegrationGateway integrationGateway;

  @PostMapping
  public Student send(@RequestBody Student student) {
    return integrationGateway.send(student);
  }
}
