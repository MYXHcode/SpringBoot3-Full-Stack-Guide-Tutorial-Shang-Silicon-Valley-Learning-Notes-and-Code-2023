package com.myxh.springboot;

import com.myxh.springboot.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MYXH
 * @date 2023/9/11
 * @description 启动 SpringBoot 项目的主入口程序
 */
// 主程序：com.myxh.springboot
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan("com.myxh.springboot")
// @SpringBootApplication(scanBasePackages = "com.myxh.springboot")

// 这是一个 SpringBoot 应用
@SpringBootApplication
public class MainApplication
{
    public static void main(String[] args)
    {
        // Java10：局部变量类型的自动推断
        var ioc = SpringApplication.run(MainApplication.class, args);

        // 1、获取容器中所有组件的名字
        String[] beanNames = ioc.getBeanDefinitionNames();

        // 2、挨个遍历
        /*
        dispatcherServlet、beanNameViewResolver、characterEncodingFilter、multipartResolver
        SpringBoot 把以前配置的核心组件现在都给自动配置好了
         */
        for (String beanName : beanNames)
        {
            System.out.println("beanName = " + beanName);
        }

        Person person = ioc.getBean(Person.class);
        System.out.println("person = " + person);

        System.out.println("------------------------------用 | 表示大文本，会保留格式------------------------------");

        String text1 = person.getChild().getText().get(2);
        System.out.println("text1 = " + text1);

        System.out.println("------------------------------用 > 表示大文本，会压缩换行变成空格------------------------------");

        String text2 = person.getChild().getText().get(3);
        System.out.println("text2 = " + text2);
    }
}
