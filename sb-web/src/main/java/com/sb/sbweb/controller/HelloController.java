package com.sb.sbweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("success")
    public String success(Map<String, Object> map){
        map.put("hello", "<h2>你好</h2>");
        map.put("users", Arrays.asList("张三", "李四", "王五"));
        return "success";
    }
}
