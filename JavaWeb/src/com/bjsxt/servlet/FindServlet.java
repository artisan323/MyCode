package com.bjsxt.servlet;

import com.google.gson.Gson;
import user.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindServlet", urlPatterns = "/FindServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("进入servlet");
        System.out.println(request.getParameter("name"));
        user u = new user(1, "赵信", "打野");
        Gson g = new Gson();
        String str = g.toJson(u);
        response.getWriter().write(str);
        System.out.println("信息返回给jsp");
    }
}
