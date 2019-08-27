package com.sb.sbamqp;
import	java.util.Arrays;

import com.sb.sbamqp.amqp.Sender;
import com.sb.sbamqp.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SbAmqpApplicationTests {

    @Autowired
    private Sender sender;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void test() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sender.send("hello");
        }

    }


    /**
     * 在rabbitmq web管理界面设置好了交换器路由键以及队列
     * 默认采用java自带的序列化策略进行序列化
     */
    @Test
    public void contextLoads(){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一条消息");
        map.put("data", Arrays.asList("hello", 123, true));

        rabbitTemplate.convertAndSend("exchange.direct", "zmx.news", map);
    }

    @Test
    public void contextLoadsBook(){
        Book book = new Book("金瓶梅", "兰陵笑笑生");
        rabbitTemplate.convertAndSend("exchange.direct", "zmx.news", book);
    }

    @Test
    public void createExchange() {

        //创建Exchange
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));

        //创建queue
        amqpAdmin.declareQueue(new Queue("amqpadmin.queue", true));

        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE, "amqpadmin.exchange", "amqp.zmx", null));
    }

}
