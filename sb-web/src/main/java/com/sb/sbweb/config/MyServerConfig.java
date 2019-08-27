package com.sb.sbweb.config;


import com.sb.sbweb.filter.MyFilter;
import com.sb.sbweb.listener.MyListener;
import com.sb.sbweb.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
    public class MyServerConfig {


    //注册Filter
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myservlet"));
        return filterRegistrationBean;
    }

    //注册servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean( new MyServlet(), "/myservlet");
        return servletRegistrationBean;
    }

    //注册监听器
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }
}
