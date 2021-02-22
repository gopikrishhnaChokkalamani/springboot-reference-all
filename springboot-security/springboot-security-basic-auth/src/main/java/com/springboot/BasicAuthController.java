package com.springboot;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicAuthController {

  @GetMapping
  //by adding this u r securing at method leve
  //soeone can auth at global level, but if they dont have the role, then this will fail
  @PreAuthorize("hasRole('USER')") // supports spring expression language
  //@Secured() //does not support expression language pass a method itself
  // @Secured({ "ROLE_ADMIN" })
  public String fetch() {
    return "Successfull Authenticated!";
  }
}