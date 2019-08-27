package com.artisan.service;

import com.artisan.ioc.annotation.Component;

/**
 * @author wannengqingnian
 */
@Component("myservice")
public class MyService {
    public void say(String s){
        System.out.println(s);
    }
}
