package com.sb.sbweb.filter;


import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤开始");
        chain.doFilter(servletRequest, servletResponse);
        System.out.println("结束...");
    }

    @Override
    public void destroy() {

    }
}
