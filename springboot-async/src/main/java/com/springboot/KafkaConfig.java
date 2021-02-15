package com.springboot;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
  
  @Value("${spring.kafka.producer.bootstrap-servers}")
  private String kafkaServer;
  
  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
    return new KafkaTemplate<>(producerConfig());
  }
  
  @Bean
  public ProducerFactory<String, String> producerConfig() {
    // TODO Auto-generated method stub
    Map<String, Object> config = new HashMap<>();
    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    //Uncomment the below if you want to send String instead of an Object through Kafka
    //config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    return new DefaultKafkaProducerFactory<>(config);
  }
  
//  To reply back on the same topic - use tbelow
//  https://callistaenterprise.se/blogg/teknik/2018/10/26/synchronous-request-reply-over-kafka/
//  @Bean
//  public KafkaMessageListenerContainer<String, String> replyListenerContainer() {
//    ContainerProperties containerProperties = new ContainerProperties("");
//    return new KafkaMessageListenerContainer<String, String>(consumerConfig(), containerProperties);
//  }
//
//  @Bean
//  public ReplyingKafkaTemplate<String, String, String> replyingKafkaTemplate() {
//    return new ReplyingKafkaTemplate<String, String, String>(producerConfig(), replyListenerContainer());
//  }
}
