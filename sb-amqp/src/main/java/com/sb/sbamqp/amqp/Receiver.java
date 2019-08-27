package com.sb.sbamqp.amqp;
import	java.util.Queue;

import com.sb.sbamqp.pojo.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * @author wannengqingnian
 */

@Component
public class Receiver {

    /**
     * 消息接收方法，采用消息队列监听机制
     * @param msg
     */
    @RabbitListener(queues = "hello")
    public void process(String msg){
        System.out.println("接收消息为：" + msg);
    }


    @RabbitListener(queues = "zmx.news")
    public void processZmx(Book book){
        System.out.println("接收到的book信息为：" + book);
    }

    @RabbitListener(queues = "zmx.news")
    public void processMessage(Message message){
        System.out.println("message body: " + message.getBody());
        System.out.println("message: " + message.getMessageProperties());
    }
}
