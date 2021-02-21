package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class JwtConfig {

  //u dont even have to do this, user WebFilter annotation
  // and remove component on filter
  //since component is added on filter spring strips its actual propery and make it like abean
  //if u add another filter u will end up creating one more... think
  @Autowired
  private JwtFilter jwtFilter;

  @Bean
  public FilterRegistrationBean<JwtFilter> filterFilterRegistrationBean() {
    FilterRegistrationBean<JwtFilter> filterRegistrationBean = new FilterRegistrationBean<>();
    filterRegistrationBean.setFilter(jwtFilter);
    filterRegistrationBean.addUrlPatterns("/secured/*");
    return filterRegistrationBean;
  }
}