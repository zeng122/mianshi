package rocket_omg;

import io.openmessaging.Message;
import io.openmessaging.MessagingAccessPoint;
import io.openmessaging.OMSBuiltinKeys;
import io.openmessaging.consumer.PullConsumer;
import io.openmessaging.internal.DefaultKeyValue;
import io.openmessaging.internal.MessagingAccessPointAdapter;
import io.openmessaging.rocketmq.domain.NonStandardKeys;

public class OpenMessagingPullConsumer {
    public static void main(String[] args) {

        DefaultKeyValue defaultKeyValue = new DefaultKeyValue();
        defaultKeyValue.put(NonStandardKeys.CONSUMER_GROUP, "consume1");
        defaultKeyValue.put(OMSBuiltinKeys.CONSUMER_ID,"1");
        defaultKeyValue.put(OMSBuiltinKeys.REGION,"OMS_HELLO_TOPIC");
        //defaultKeyValue.put(OMSBuiltinKeys.OPERATION_TIMEOUT, );
        final MessagingAccessPoint messagingAccessPoint = MessagingAccessPointAdapter
                .getMessagingAccessPoint("oms:rocketmq://***:9876/topic-1", defaultKeyValue);

        final PullConsumer consumer = messagingAccessPoint
                .createPullConsumer(defaultKeyValue);
        //设置topic
        consumer.attachQueue("OMS_HELLO_TOPIC",defaultKeyValue);
        messagingAccessPoint.startup();
        System.out.printf("MessagingAccessPoint startup OK%n");


        System.out.printf("Consumer startup OK%n");
        consumer.startup();

        Integer count = 0;
        //轮询，获取message
        while(true) {
            System.out.println("轮询："+ count++);
            Message message = consumer.receive();

            if (message != null) {

                System.out.println("body:>>>"+new String(message.getBody(byte[].class)));
                String msgId = message.sysHeaders().getString(Message.BuiltinKeys.MESSAGE_ID);
                System.out.printf("Received one message: %s%n", msgId);
                consumer.ack(msgId);
            }
        }


//		consumer.shutdown();
//		messagingAccessPoint.shutdown();
    }
}
