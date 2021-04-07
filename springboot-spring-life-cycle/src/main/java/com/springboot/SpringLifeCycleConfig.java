package com.springboot;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;

@Configuration
public class SpringLifeCycleConfig {

  @Bean(initMethod = "init_Method", destroyMethod = "destroy_Method")
  public SpringLifeCycle springLifeCycle() {
    return new SpringLifeCycle();
  }

  @Bean
  public SpringLifeCycleBeanPostProcessor springLifeCycleBeanPostProcessor() {
    SpringLifeCycleBeanPostProcessor p = new SpringLifeCycleBeanPostProcessor();
    //p.postProcessBeforeInitialization(springLifeCycle(), "springLifeCycle");
   // p.postProcessAfterInitialization(springLifeCycle(), "springLifeCycle");
    return p;
  }
}
