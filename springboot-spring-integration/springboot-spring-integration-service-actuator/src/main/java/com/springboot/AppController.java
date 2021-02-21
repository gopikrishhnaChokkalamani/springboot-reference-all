package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/integration")
public class AppController {

  @Autowired
  private IntegrationGateway integrationGateway;

  @GetMapping
  public String fetch(@RequestParam("name") String name) throws ExecutionException, InterruptedException {
    //Future<String> f = integrationGateway.sendMessage(name);
    CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> integrationGateway.sendMessage(name));
    return cf.getNow("processing");
  }
}
