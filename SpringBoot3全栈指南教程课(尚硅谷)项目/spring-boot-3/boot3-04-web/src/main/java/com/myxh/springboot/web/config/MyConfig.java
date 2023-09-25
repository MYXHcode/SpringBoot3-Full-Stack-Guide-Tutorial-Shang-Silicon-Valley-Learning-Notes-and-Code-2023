package com.myxh.springboot.web.config;

import com.myxh.springboot.web.component.MyYamlHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author MYXH
 * @date 2023/9/18
 */
// 禁用 Spring Boot 的默认配置
// @EnableWebMvc
// 这是一个配置类，给容器中放一个 WebMvcConfigurer 组件，就能自定义底层
/*
@Configuration
public class MyConfig implements WebMvcConfigurer
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        // 保留默认规则
        WebMvcConfigurer.super.addResourceHandlers(registry);

        // 新增自定义规则
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/image/, classpath:/static/")
                .setCacheControl(CacheControl.maxAge(7200, TimeUnit.SECONDS));
    }
}
 */

@Configuration
public class MyConfig
{
    @Bean
    public WebMvcConfigurer webMvcConfigurer()
    {
        return new WebMvcConfigurer()
        {
            /**
             * 配置静态资源
             *
             * @param registry 注册表
             */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry)
            {
                // 保留默认规则
                WebMvcConfigurer.super.addResourceHandlers(registry);

                // 新增自定义规则
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/image/, classpath:/static/")
                        .setCacheControl(CacheControl.maxAge(7200, TimeUnit.SECONDS));
            }

            /**
             * 配置拦截器
             *
             * @param registry 注册表
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry)
            {
                WebMvcConfigurer.super.addInterceptors(registry);
            }

            /**
             * 配置一个能把对象转为 yaml 的 messageConverter
             *
             * @param converters 最初是转换器的空列表
             */
            @Override
            public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
            {
                converters.add(new MyYamlHttpMessageConverter());
            }
        };
    }
}
