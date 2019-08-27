package com.sb.sbamqp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable("id") String id){
        return "id = " + id;
    }

    @GetMapping("/hi")
    public String hi(@RequestParam(value = "myname", defaultValue = "admin") String name){
        return "name = " + name;
    }
}
