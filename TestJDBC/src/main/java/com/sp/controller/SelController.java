package com.sp.controller;


import com.sp.pojo.User;
import com.sp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class SelController {

    @Resource
    UserService userService;

    @RequestMapping("login")
    public String login(){
        return "login.jsp";
    }

    @RequestMapping("res")
    public String res(){
        return "res.jsp";
    }

    @RequestMapping("issuccess")
    public String issuccess(String uname, int password, Model model){

        User user = userService.show(uname);

        if (user == null){
            return "error.jsp";
        }else if (user.getPassword() == password){
            model.addAttribute("user", user);
            System.out.println(user);
            return "success.jsp";
        }else {
            return "error.jsp";
        }

    }

    @RequestMapping("zhuce")
    public String zhuce(String uname, String usex, int password, Model model){
        User user = new User(2, uname, usex, password);
        model.addAttribute("user", user);
        return "success.jsp";
    }

}
