package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private TokenAuthenticationProvider authenticationProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
            .antMatcher("/secured/**")
            .authorizeRequests().anyRequest()
            .authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint((req, res, ex) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "401-UNAUTHORIZED"))
            .and()
            .addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider);
  }

  @Bean
  public TokenAuthenticationFilter authenticationTokenFilter() throws Exception {
    TokenAuthenticationFilter filter = new TokenAuthenticationFilter();
    filter.setAuthenticationManager(authenticationManagerBean());
    filter.setAuthenticationSuccessHandler(new TokenAuthenticationSuccessHandler());
    return filter;
  }
}
