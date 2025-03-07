package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity  //global api level
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = false) //gloval method level
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${basic.app.security.user-name}")
  private String username;

  @Value("${basic.app.security.password}")
  private String password;

  @Value("${basic.app.security.role}")
  private String role;

  @Autowired
  private BasicAuthEntryPoint basicAuthEntryPoint;

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser(username).password(password).roles(role);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().formLogin().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic()
            .authenticationEntryPoint(basicAuthEntryPoint);
  }
}

//csrf - u need login and then u trick the user to click on some other link - authentication is needed
//xss - cross site scripting - u inject some js code in the browser console and completely alter the behaviour of the app
//sql injection - if u have used ? in jdbctemplate, and ur web application is taking some data, u inject 1=1 it will return
//all data from the database