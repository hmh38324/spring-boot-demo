package rabbitmq.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class Producer {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {
        ConnectionFactory factory =  new ConnectionFactory();
        factory.setHost("192.168.10.137");
        factory.setUsername("admin");
        factory.setPassword("123");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message = "hell rabbitmq";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println("消息发送完毕！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

}
