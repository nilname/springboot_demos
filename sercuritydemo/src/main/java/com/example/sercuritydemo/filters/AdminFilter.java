package com.example.sercuritydemo.filters;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@Order(FilterRegistrationBean.HIGHEST_PRECEDENCE)
//@WebFilter(filterName = "admin" ,urlPatterns = "/*") //web filter 属于servelet不能影响spring的行为但是他们可以同时使用
@Component
@Order(5)
public class AdminFilter implements Filter, Ordered {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filtering  AdminFilter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    @Override
    public int getOrder() {
        return 200;
    }
}
