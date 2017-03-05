package com.star.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * Created by hp on 2017/3/4.
 */
@Configuration
@EnableWebSecurity //启用Web安全性配置
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /*
    * 定义用户存储，可选的有内存、数据库、LDAP、自定义
    * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhou").password("123").roles("USER")  //赋予权限
                .and()
                .withUser("admin").password("admin").roles("ADMIN","USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //下面两行作用是启用默认登录页
                .formLogin().successForwardUrl("/loginSuccess")
                    .loginPage("/login")
                .and()
                .rememberMe()  //启用“记住我"功能
                    .tokenValiditySeconds(2419200)
                    .key("SSDKey")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/") //指定退出成功后重定向到的页面
                .and()
                .authorizeRequests()
                .antMatchers("/mine").hasRole("USER")
                .anyRequest().permitAll();
                //.and()
                //.requiresChannel()
                //.antMatchers("/regist").requiresSecure();
    }
}
