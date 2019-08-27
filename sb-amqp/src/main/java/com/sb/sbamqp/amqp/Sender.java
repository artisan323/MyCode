package com.sb.sbamqp.amqp;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wannengqingnian
 */
@Component
public class Sender {

    @Autowired
    AmqpTemplate amqpTemplate;


    /**
     * 发送消息
     * @param message
     */
    public void send(String message){
        amqpTemplate.convertAndSend("hello", message);
    }
}
