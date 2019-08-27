package com.sp.controller;

import com.sp.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@Controller
public class DemoController {
    @RequestMapping("demo")
    //@RequestParam 解决前段后端参数名称不一致问题
    public String demo(@RequestParam(value="name") String name1, @RequestParam(value="pass") int pass1){
        System.out.println("执行demo " + name1 + pass1);
        return "main.jsp";
    }


    @RequestMapping("demo2")
    //@RequestParam 设置默认值
    public String demo2(@RequestParam(defaultValue = "2") int pageSize, @RequestParam(defaultValue = "1") int pageNum){
        System.out.println(pageSize + " " + pageNum);
        return "main.jsp";
    }

    @RequestMapping("demo3")
    //@RequestParam 必须传参数,不传参数跑异常
    public String demo3(@RequestParam(required = true) String name){
        System.out.println("name是SQL查询条件，必须要传递name参数 " + name);
        return "main.jsp";
    }

    @RequestMapping("demo4")
    public String demo4(String name, int pass,@RequestParam("hover") ArrayList<String> haver){
        System.out.println(haver);
        return  "main.jsp";
    }


    //restful风格传值
    @RequestMapping("demo5/{name}/{pass}")
    public String demo5(@PathVariable String name, @PathVariable int pass){
        System.out.println(name + pass);
        return "/main.jsp";//此时需要全路径
    }

    //默认请求转发方式，在名称前加上redirect：表示重定向
    @RequestMapping("demo6")
    public String demo6(){
        return "redirect:main.jsp";
    }

    @RequestMapping("demo7")
    public void demo7(HttpServletResponse resp) throws IOException {
        PrintWriter out =  resp.getWriter();
        out.write("asd");
        out.flush();
        out.close();
    }

    @RequestMapping("demo8")
    @ResponseBody  //底层使用jackson
    public Person demo8(){
        Person p = new Person("赵铭轩", 123);
        return p;
    }


    //解决返回字符换乱码问题 设置响应头
    @RequestMapping(value = "demo9", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String demo9(){
        return "中文";
    }
}
