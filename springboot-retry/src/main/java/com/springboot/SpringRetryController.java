package com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/retry")
public class SpringRetryController {

//  in the cloud computing world, the fact is that we cannot avoid network glitches,
//  temporary service downtime (due to a restart or crash; not more than a few seconds).
//  When clients need real-time data and your downstream service is not responding
//  momentarily, it may impact the users, so you should create a retry mechanism.
  // or else if you are calling a downstream through API gateway, initially before the load
  //picks up, it might result in error, as API gateway might warm up after a particular numer of requests which requests will be serviced

  //https://dzone.com/articles/spring-retry-way-to-handle-failures

  //try to restrict as much as possible to a specific exception
  //if first fails, backoff will wait till 5000 and then call next and then next

  @GetMapping
  @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(delay = 5000))
  public String get() {
    log.info("Exception occurred {}", "get()");
    throw new RuntimeException();
  }

  //if the method has any arguments you can access them in recover method like below
  //public String recover(RuntimeException e, Student student)

  @Recover
  public String recover(RuntimeException e) {
    return "recovered after 3 times retried!";
  }
}
