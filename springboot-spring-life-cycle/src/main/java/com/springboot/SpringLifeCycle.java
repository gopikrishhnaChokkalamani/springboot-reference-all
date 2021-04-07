package com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class SpringLifeCycle implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware,
        BeanFactoryAware, MessageSourceAware, NotificationPublisherAware, ApplicationContextAware, ResourceLoaderAware,
        ApplicationEventPublisherAware, LoadTimeWeaverAware {

  @Override
  public void setBeanClassLoader(ClassLoader classLoader) {
    //log.info("setBeanClassLoader called");
    System.out.println("setBeanClassLoader called");
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    System.out.println("setBeanFactory called");
  }

  @Override
  public void setBeanName(String name) {
    System.out.println("setBeanName called");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("destroy called");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("afterPropertiesSet called");
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("postConstruct called");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("preDestroy called");
  }

  public void init_Method() {
    System.out.println("init_Method called");
  }

  public void destroy_Method() {
    System.out.println("destroy_Method called");
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    System.out.println("setApplicationContext called");
  }

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    System.out.println("setApplicationEventPublisher called");
  }

  @Override
  public void setMessageSource(MessageSource messageSource) {
    System.out.println("setMessageSource called");
  }

  @Override
  public void setResourceLoader(ResourceLoader resourceLoader) {
    System.out.println("setResourceLoader called");
  }

  @Override
  public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
    System.out.println("setLoadTimeWeaver called");
  }

  @Override
  public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
    System.out.println("setNotificationPublisher called");
  }
}
