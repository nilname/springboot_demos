package com.example.sercuritydemo.servlet;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@Component
@Order(0)
@WebServlet(urlPatterns = "/adminx")
public class AdminServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println(req.getParameter("name"));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
