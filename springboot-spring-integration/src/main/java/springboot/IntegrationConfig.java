package springboot;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.filter.MessageFilter;
import org.springframework.integration.gateway.MethodArgsHolder;
import org.springframework.integration.gateway.MethodArgsMessageMapper;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;
import org.springframework.integration.router.HeaderValueRouter;
import org.springframework.integration.support.MutableMessageHeaders;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapper;
import org.springframework.integration.transformer.HeaderEnricher;
import org.springframework.integration.transformer.support.HeaderValueMessageProcessor;
import org.springframework.integration.transformer.support.StaticHeaderValueMessageProcessor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig {
//
//  @Bean
//  public MessageChannel messageChannel() {
//    return new DirectChannel();
//  }
//
//  @Bean
//  public MessageChannel replyChannel() {
//    return new DirectChannel();
//  }

  @Bean
  @Transformer(inputChannel = "integration.transformer.channel", outputChannel = "integration.after.transform.channel")
  public ObjectToJsonTransformer objectToJsonTransformer() {
    return new ObjectToJsonTransformer(getMapper());
  }

  @Bean
  public Jackson2JsonObjectMapper getMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    return new Jackson2JsonObjectMapper(objectMapper);
  }

  @Bean
  @Transformer(inputChannel = "integration.header-enricher.channel", outputChannel = "integration.transformer.channel")
  public HeaderEnricher headerEnricher() {
    Map<String, HeaderValueMessageProcessor<?>> headersToAdd = new HashMap<>();
    headersToAdd.put("header1", new StaticHeaderValueMessageProcessor<String>("Header1"));
    headersToAdd.put("header2", new StaticHeaderValueMessageProcessor<String>("Header1"));
    HeaderEnricher enricher = new HeaderEnricher(headersToAdd);
    return enricher;
  }


  //if you want to transform from the json string to object
//  @Bean
//  @Transformer(inputChannel = "integration.student.jsonToObject.channel", outputChannel = "integration.student.jsonToObject.fromTransformer.channel")
//  JsonToObjectTransformer jsonToObjectTransformer() {
//    return new JsonToObjectTransformer(Student.class);
//  }

  // PayloadTypeRouter Example - based on the type send to the channel
//  @ServiceActivator(inputChannel = "router.channel")
//  @Bean
//  public PayloadTypeRouter payloadRouter() {
//    PayloadTypeRouter router = new PayloadTypeRouter();
//    router.setChannelMapping(Student.class.getName(), "student.channel");
//    router.setChannelMapping(Address.class.getName(), "address.channel");
//    return router;
//  }

  // Header Value Router - based on a header, can send to one or multiple channels
//	@ServiceActivator(inputChannel = "header.payload.router.channel") //or @Router
//	@Bean
//	public HeaderValueRouter headerRouter() {
//		HeaderValueRouter router = new HeaderValueRouter("testHeader");
//		router.setChannelMapping("student", "student.channel");
//		router.setChannelMapping("address", "address.channel");
//		return router;
//	}

  // Recipient List Router - send to multiple different services
	/*@ServiceActivator(inputChannel = "recipient.payload.router.channel")
	@Bean
	public RecipientListRouter recipientListRouter() {
		RecipientListRouter router = new RecipientListRouter();
		router.setSendTimeout(1_234L);
		router.setIgnoreSendFailures(true);
		router.setApplySequence(true);
		router.addRecipient("student.channel");
		router.addRecipient("address.channel");
		router.addRecipient("channel3");
		return router;
	}*/

  @Bean
  @Filter(inputChannel = "integration.filter.channel")
  public MessageFilter messageFilter() {
    MessageFilter filter = new MessageFilter(new MessageSelector() {  //use lambda
      @Override
      public boolean accept(Message<?> message) {
        //u can do whatever condition u need here to verify for any filtering conditions
        //we are just checking instance of Student class
        //if fails it drops the request here itself.. think about how to handle error in this case
        return message.getPayload() instanceof Student;
      }
    });
    filter.setOutputChannelName("integration.filter.output.channel");
    return filter;
  }

  @Bean
  public JedisConnectionFactory connectionFactory() {
    return new JedisConnectionFactory();
  }

  @Bean
  public RedisQueueMessageDrivenEndpoint redisQueueMessageDrivenEndpoint() {
    RedisQueueMessageDrivenEndpoint endpoint = new RedisQueueMessageDrivenEndpoint("redis-queue",
            connectionFactory());
    endpoint.setExpectMessage(true);
    endpoint.setOutputChannelName("receiverChannel");
    return endpoint;
  }

  @Bean
  public DirectChannel receiverChannel() {
    return new DirectChannel();
  }

//  @Bean
//  public MethodArgsMessageMapper setMessageHeaders() {
//    return new MethodArgsMessageMapper() {
//      @Override
//      public Message<?> toMessage(MethodArgsHolder object) {
//        MutableMessageHeaders headers = new MutableMessageHeaders(new HashMap<>());
//        headers.put("correlation.id", UUID.randomUUID().toString());
//        return org.springframework.messaging.support.MessageBuilder.createMessage(object.getArgs()[0], headers);
//      }
//
//      @Override
//      public Message<?> toMessage(MethodArgsHolder methodArgsHolder, Map<String, Object> map) {
//        MutableMessageHeaders headers = new MutableMessageHeaders(new HashMap<>());
//        headers.put("correlation.id", UUID.randomUUID().toString());
//        return org.springframework.messaging.support.MessageBuilder.createMessage(methodArgsHolder.getArgs()[0], headers);
//      }
//    };
//  }
}
