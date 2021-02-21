package com.springboot;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  protected TokenAuthenticationFilter() {
    super("/secured/**");
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
    AuthToken token = TokenAuthenticationFilter.validateHeader(req.getHeader("Authorization"));
    if (token == null || token.getToken() == null) {
      throw new ServletException("401 - UNAUTHORIZED");
    }
    return getAuthenticationManager().authenticate(token);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
    super.successfulAuthentication(request, response, chain, authResult);
    chain.doFilter(request, response);
  }

  private static AuthToken validateHeader(String authenticationHeader) {
    if (StringUtils.isBlank(authenticationHeader) || !authenticationHeader.startsWith("Bearer")) {
      return null;
    }
    return new AuthToken(authenticationHeader.replace("Bearer", ""));
  }
}
