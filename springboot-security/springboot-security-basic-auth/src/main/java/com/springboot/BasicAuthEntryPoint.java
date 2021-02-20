package com.springboot;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class BasicAuthEntryPoint extends BasicAuthenticationEntryPoint {

  @Override
  public void afterPropertiesSet() {
    setRealmName("basic-auth-app");
    super.afterPropertiesSet();
  }

  //here we are going to configure the message that we are going to return back in case of auth failure
  //u can do this using lambdd and skip creating this class itself
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
    response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    PrintWriter writer = response.getWriter();
    writer.println("401 - UNAUTHORIZED");
  }
}
