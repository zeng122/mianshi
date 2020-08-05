package rocket_omg;

import io.openmessaging.Future;
import io.openmessaging.FutureListener;
import io.openmessaging.Message;
import io.openmessaging.MessagingAccessPoint;
import io.openmessaging.internal.DefaultKeyValue;
import io.openmessaging.internal.MessagingAccessPointAdapter;
import io.openmessaging.producer.Producer;
import io.openmessaging.producer.SendResult;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * OpenMessaging 是啥东西。这是一种新兴的理论，可以说是理论吧，因为他并没有新技术的产生，
 * 更像是一种总结，统一管理的概念。大概意思就是，现在消息队列产品太多了比如，rocketMQ,rabbitMq,
 * kafaka,****啥的，每一种消息发布产品都有局限性，比如语言，平台，消息规范，序列化啥的。为
 * 了避免这种问题，阿里的高级架构师，就提出需要统一度量衡，并率先在自家产品RocketMq 的身
 * 上提供的具体的实现，不过这种实现由于提出不久，所以功能比较单一，不是很强大。
 */
public class Provider {
    public static  void main(String [] args){

        DefaultKeyValue defaultKeyValue = new DefaultKeyValue();
        final MessagingAccessPoint messagingAccessPoint = MessagingAccessPointAdapter.
                getMessagingAccessPoint("oms:rocketmq://ip:9876/topic-1",defaultKeyValue);
        final Producer producer = messagingAccessPoint.createProducer();
        messagingAccessPoint.startup();
        System.out.printf("MessagingAccessPoint startup OK%n");
        producer.startup();
        System.out.printf("Producer startup OK%n");

        {
            Message message = null;
            message = producer.createBytesMessage(
                        "OMS_HELLO_TOPIC", "OMS_HELLO_BODY".getBytes(StandardCharsets.UTF_8));
            SendResult sendResult = producer.send(message);
            System.out.printf("Send sync message OK, msgId: %s%n", sendResult.messageId());
        }

        {
            final Future<SendResult> result;
            try {
                result = producer.sendAsync(producer.createBytesMessage("OMS_HELLO_TOPIC", "OMS_HELLO_BODY".getBytes("UTF-8")));
                result.addListener(new FutureListener<SendResult>() {

                    public void operationComplete(Future<SendResult> future) {
                        System.out.printf("Send async message OK, msgId: %s%n", future.get().messageId());
                    }
                });
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }


        }

        {
            try {
                producer.sendOneway(producer.createBytesMessage("OMS_HELLO_TOPIC", "OMS_HELLO_BODY".getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.printf("Send oneway message OK%n");
        }

        producer.shutdown();
        messagingAccessPoint.shutdown();
    }
}
