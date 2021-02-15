package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/async")
public class SpringAsyncController {

  @Autowired
  private SpringAsyncService springAsyncService;

  @PostMapping
  public void sendMessage(@RequestBody Student student) throws ExecutionException, InterruptedException {
    springAsyncService.sendMessage(student);
  }
}
