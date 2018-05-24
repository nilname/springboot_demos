package com.example.sercuritydemo.listeners;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
@Order(0)
public class AdminListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Admin Listern init");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Admin Listern destroyed");
    }
}
