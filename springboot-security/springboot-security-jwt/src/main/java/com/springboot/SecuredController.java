package com.springboot;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured/api")
public class SecuredController {

  @GetMapping
  public String securedMethod() {
    return "Welcome, you are an authorized user!";
  }
}
