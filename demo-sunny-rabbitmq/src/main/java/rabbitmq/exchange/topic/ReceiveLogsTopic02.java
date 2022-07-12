package rabbitmq.exchange.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.utils.RabbitUtils;

/**
 * Q2-->绑定的是
 * 最后一个单词是 rabbit 的 3 个单词(*.*.rabbit)
 * 第一个单词是 lazy 的多个单词(lazy.#)
 *
 */
public class ReceiveLogsTopic02 {
    private static final String EXCHANGE_NAME = "topic_logs";
    public static void main(String[] argv) throws Exception {
        Channel channel = RabbitUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
//声明 Q2 队列与绑定关系
        String queueName="Q2";
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, EXCHANGE_NAME, "*.*.rabbit");
        channel.queueBind(queueName, EXCHANGE_NAME, "lazy.#");
        System.out.println("等待接收消息.....");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" 接 收 队 列 :"+queueName+" 绑 定 键:"+delivery.getEnvelope().getRoutingKey()+",消息:"+message);
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}
