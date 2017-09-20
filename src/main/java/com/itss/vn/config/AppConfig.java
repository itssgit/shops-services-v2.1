package com.itss.vn.config;

import com.itss.vn.interceptor.FillterInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created on 19-Sep-17.
 * OwnerBy anhvu
 */
public class AppConfig extends WebMvcConfigurerAdapter {

    public AppConfig() {
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FillterInterceptor()).addPathPatterns("/shops-services/*");

    }
}
