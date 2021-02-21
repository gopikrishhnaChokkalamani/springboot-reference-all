package com.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured/v1/app")
public class SecuredController {

  @GetMapping
  public String fetch() {
    return "Welcome!, you are a secured user";
  }
}
