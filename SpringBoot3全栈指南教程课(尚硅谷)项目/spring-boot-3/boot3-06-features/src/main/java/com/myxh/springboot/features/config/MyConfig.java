package com.myxh.springboot.features.config;

import com.myxh.springboot.features.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * @author MYXH
 * @date 2023/9/23
 */
@PropertySource("classpath:/a.properties")
// 只有指定环境被激活，整个类的所有配置才能生效
@Profile("test")
@Configuration
public class MyConfig
{
    @Profile("dev")
    @Bean
    public Cat cst()
    {
        return new Cat();
    }
}
