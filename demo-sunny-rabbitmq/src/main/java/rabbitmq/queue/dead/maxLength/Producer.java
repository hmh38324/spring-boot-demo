package rabbitmq.queue.dead.maxLength;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import rabbitmq.utils.RabbitUtils;

public class Producer {
    private static final String NORMAL_EXCHANGE = "normal_exchange";

    public static void main(String[] argv) throws Exception {
        try (Channel channel = RabbitUtils.getChannel()) {
            channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
// 该信息是用作演示队列个数限制
            for (int i = 1; i < 11; i++) {
                String message = "info" + i;
                channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", null, message.getBytes());
                System.out.println("生产者发送消息:" + message);
            }
        }
    }
}
