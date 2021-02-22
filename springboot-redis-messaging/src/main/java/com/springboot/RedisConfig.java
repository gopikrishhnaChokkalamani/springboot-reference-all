package com.springboot;

import java.util.UUID;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {

  @Bean
  JedisConnectionFactory connectionFactory() {
    JedisConnectionFactory factory = new JedisConnectionFactory();
    return factory;
  }

  @Bean
  public RedisTemplate<String, String> redisTemplate() {
    RedisTemplate<String, String> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory());
    template.setValueSerializer(new GenericToStringSerializer<String>(String.class));
    return template;
  };

  @Bean
  ChannelTopic topic() {
    return new ChannelTopic(UUID.randomUUID().toString());
  }

  @Bean
  RedisMessageListenerContainer redisContainer() {
    RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(connectionFactory());
    container.addMessageListener(new MessageListenerAdapter(new RedisReciever()), topic());
    container.setTaskExecutor(Executors.newFixedThreadPool(4)); //even though redis queue is single threaded
    //it is super fast, here we are making the container to execute with multiple threads to listen and process
    return container;
  }

}