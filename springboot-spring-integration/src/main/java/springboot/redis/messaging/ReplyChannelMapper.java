package springboot.redis.messaging;

import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ReplyChannelMapper {

  private Map<String, MessageChannel> replyChannels = new ConcurrentHashMap<>();

  public Map<String, MessageChannel> getReplyChannels() {
    return replyChannels;
  }

  public void setReplyChannels(String name, MessageChannel replyChannel) {
    replyChannels.put(name, replyChannel);
  }
}
