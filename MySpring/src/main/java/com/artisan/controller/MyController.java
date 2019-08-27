package com.artisan.controller;

import com.artisan.ioc.ApplicationContext;
import com.artisan.ioc.annotation.Autowire;
import com.artisan.ioc.annotation.Controller;
import com.artisan.ioc.support.AnnotationApplicationContext;
import com.artisan.service.MyService;

/**
 * @author wannengqingnian
 */
@Controller
public class MyController {

    @Autowire("myservice")
    MyService service;

    public void test(){
        service.say("hello word");
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationApplicationContext("applicationContext.properties");
        MyController controller = context.getBean("com.artisan.controller.MyController", MyController.class);
        controller.test();
        controller.service.say("hel");
    }
}

