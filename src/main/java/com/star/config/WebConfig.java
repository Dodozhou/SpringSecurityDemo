package com.star.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * Created by hp on 2017/3/4.
 */
@Configuration
@EnableWebMvc    //启用SpringMVC
@ComponentScan(basePackages = {"com.star"})
public class WebConfig  extends WebMvcConfigurerAdapter{
    //配置Thymeleaf视图处理器
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        //解决页面中文乱码问题，与templateResolver同时存在
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    //配置模板引擎
    @Bean
    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver){
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        //注册安全方言，以便在Thymeleaf页面中使用Thymeleaf Security标签
        //使用之前要引入thymeleaf-extras-springsecurity4依赖
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }

    //配置模板解析器
    @Bean
    public TemplateResolver templateResolver(){
        TemplateResolver templateResolver=new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");   //解决页面中文乱码问题
        return templateResolver;
    }

    //转发静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
