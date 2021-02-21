package com.springboot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Getter
@Setter
public class AuthToken extends UsernamePasswordAuthenticationToken {

  private String token;

  public AuthToken(String token) {
    super(null, null);
    this.token = token;
  }
}
