package com.star.initializer;

import com.star.config.RootConfig;
import com.star.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by hp on 2017/3/4.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //将DispatcherServlet映射到“/”
    @Override
    protected String[] getServletMappings() {
        return new String [] {"/"};
    }

    //指定web配置类，DispatcherServlet
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }
    //指定根配置类，可用来组合各种配置文件,ContextLoderListener
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }
}
