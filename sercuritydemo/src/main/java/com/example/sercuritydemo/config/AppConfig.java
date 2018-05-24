package com.example.sercuritydemo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import com.example.sercuritydemo.service.myuserService;

@EnableWebSecurity
@Configuration
//@EnableAutoConfiguration
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder builder)
            throws Exception {

        builder.userDetailsService(myuserService()).passwordEncoder(NoOpPasswordEncoder.getInstance());
//        builder.inMemoryAuthentication()
//                .withUser("zhangsan")
//                .password("zhangsan")
//                .roles("ADMIN");
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public myuserService myuserService() {
        return new myuserService();
    }


}
