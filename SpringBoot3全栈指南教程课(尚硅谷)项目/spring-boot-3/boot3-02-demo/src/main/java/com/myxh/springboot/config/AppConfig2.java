package com.myxh.springboot.config;

import com.myxh.springboot.bean.Cat;
import com.myxh.springboot.bean.Dog;
import com.myxh.springboot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

/*
 * @author MYXH
 * @date 2023/9/11
 */
@SpringBootConfiguration
public class AppConfig2
{
    @Bean
    // 放在方法级别，单独对这个方法进行注解判断
    // 放在类级别，如果注解判断生效，则整个配置类才生效
    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    public Cat cat1()
    {
        return new Cat();
    }

    @Bean
    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    public Dog dog1()
    {
        return new Dog();
    }

    @Bean
    @ConditionalOnBean(name = "dog1")
    public User zhangsan()
    {
        return new User();
    }

    @Bean
    @ConditionalOnMissingBean(name = "dog1")
    public User lisi()
    {
        return new User();
    }
}
