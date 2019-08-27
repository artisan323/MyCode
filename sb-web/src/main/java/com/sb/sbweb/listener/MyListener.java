package com.sb.sbweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//监听启动销毁
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("项目启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("项目销毁");
    }
}
