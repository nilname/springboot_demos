package com.example.sercuritydemo.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@Order(FilterRegistrationBean.HIGHEST_PRECEDENCE)
//@WebFilter(filterName = "user", urlPatterns = "/*")
@Component
@Order(2)
public class UserFilter implements Filter ,Ordered{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("userFilter filtering!");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }

    @Override
    public int getOrder() {
        return 100;
    }
}
