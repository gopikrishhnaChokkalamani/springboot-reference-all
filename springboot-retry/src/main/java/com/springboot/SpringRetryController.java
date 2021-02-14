package com.springboot;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retry")
public class SpringRetryController {

//  in the cloud computing world, the fact is that we cannot avoid network glitches,
//  temporary service downtime (due to a restart or crash; not more than a few seconds).
//  When clients need real-time data and your downstream service is not responding
//  momentarily, it may impact the users, so you should create a retry mechanism.
  // or else if you are calling a downstream through API gateway, initially before the load
  //picks up, it might result in error, as API gateway might warm up after which requests will be serviced


  @GetMapping
  @Retryable(value = RuntimeException.class)
  public String get() {
    throw new RuntimeException();
  }

  @Recover
  public String recover(RuntimeException e) {
    return "recovered after 3 times retried!";
  }
}
