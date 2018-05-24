package com.example.demomybatis.config;

import com.example.demomybatis.service.myuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity

public class AppConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       super.configure(http);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //这里是新增一个默认用户
        auth.inMemoryAuthentication().withUser("zhangsan").password("zhangsan").roles("ADMIN");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( myuserService()).passwordEncoder(NoOpPasswordEncoder.getInstance() );
    }

    @Bean
    myuserService myuserService(){ //注册UserDetailsService 的bean
        return new myuserService();
    }
//    @Bean
//    public SessionRegistry getSessionRegistry(){
//        SessionRegistry sessionRegistry = new SessionRegistryImpl();
//        return sessionRegistry;
//    }


}
