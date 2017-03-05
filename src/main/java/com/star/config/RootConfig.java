package com.star.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by hp on 2017/3/4.
 */
@Configuration
@ComponentScan(basePackages = {"com.star"}, excludeFilters = {
        @ComponentScan.Filter(
        type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class RootConfig {

}
