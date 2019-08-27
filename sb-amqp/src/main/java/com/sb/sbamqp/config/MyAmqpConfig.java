package com.sb.sbamqp.config;
import	java.beans.BeanInfo;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用json格式进行序列化
 * @author wannengqingnian
 */
@Configuration
public class MyAmqpConfig {

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
