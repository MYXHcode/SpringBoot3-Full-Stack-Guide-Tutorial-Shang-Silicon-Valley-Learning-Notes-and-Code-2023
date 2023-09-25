package com.myxh.springboot.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author MYXH
 * @date 2023/9/18
 */
// 禁用 SpringMVC 的默认功能,全面接管 SpringMVC
// @EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer
{

}
