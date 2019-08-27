package com.sb.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @Value("${name}")
    private String name;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "helloword"+name;

    }
}
