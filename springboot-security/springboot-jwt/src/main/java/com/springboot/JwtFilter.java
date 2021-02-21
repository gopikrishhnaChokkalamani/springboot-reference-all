package com.springboot;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JwtFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    final HttpServletRequest request = (HttpServletRequest) req;
    final String authorization = request.getHeader("authorization");

    if (authorization == null || !authorization.startsWith("Bearer ")) {
      //res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      //PrintWriter writer = res.getWriter();
      //writer.println("401 - UNAUTHORIZED");
      throw new ServletException("401 - UNAUTHORIZED");
    }
    final Claims claims = Jwts.parser()
            .setSigningKey("123#&*zcvAWEE999")
            .parseClaimsJws(authorization.substring(7))  //after the space
            .getBody();
    req.setAttribute("claims", claims);
    chain.doFilter(req, res);
  }
}
