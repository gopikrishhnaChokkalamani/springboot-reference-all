package springboot.redis.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class RedisIntegrationMessageListener {

  @Autowired
  private JedisConnectionFactory factory;

  @Autowired
  private ReplyChannelMapper replyChannelMapper;

  @ServiceActivator(inputChannel = "redis-integration.request.channel",
          outputChannel = "redis-integration.send-to.redis.queue")
  public Message<?> recieve(Message<?> message) {
    System.out.println("Message recieved from service sending to Redis");
    replyChannelMapper.setReplyChannels(String.valueOf(message.getHeaders().get("id")),
            (MessageChannel) message.getHeaders().getReplyChannel());
    Message<?> messageBuilder = MessageBuilder.fromMessage(message)
            .setHeader("correlation.id", message.getHeaders().get("id"))
            .build();
    return messageBuilder;
  }

  @ServiceActivator(inputChannel = "redis-integration.send-to.redis.queue")
  public void sendToQueue(Message<?> message) {
    RedisQueueOutboundChannelAdapter adapter = new RedisQueueOutboundChannelAdapter("redis-queue", factory);
    adapter.setExtractPayload(false);
    adapter.handleMessage(message);
  }

  //just adding output channel will not guarantee message been returned back for the right request
  // u will need to have a map of id and replychannels and try to get that reply channel from the map
  // and then wire the response back
  @ServiceActivator(inputChannel = "receiverChannel")
  public void recieveFromQueue(Message<?> message) {
    String corId = message.getHeaders().get("correlation.id").toString();
    if (replyChannelMapper.getReplyChannels().containsKey(corId)) {
      MessageChannel reply = replyChannelMapper.getReplyChannels().get(corId);
      replyChannelMapper.getReplyChannels().remove(corId);
      reply.send(message);
    }
    //MessageChannel reply = (MessageChannel) message.getHeaders().getReplyChannel();
    //MessageBuilder.fromMessage(message);
    //Message<String> newMessage = MessageBuilder
    //        .withPayload("Welcome " + message.getPayload() + " to string integration").build();
   // Thread.sleep(3000);
    System.out.println("processed Message");
    //reply.send(newMessage);
  }
}
