package com.myxh.springboot.core;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * SPI 机制：Service Provider Interface 服务提供商接口
 */
// 全面接管 SpringMVC，禁用所有 SpringMVC 底层的自动配置
// @EnableWebMvc
// 开启异步
@EnableAsync
// 开启定时任务
// @EnableScheduling
@SpringBootApplication
public class Boot307CoreApplication
{
    public static void main(String[] args)
    {
        // SpringApplication.run(Boot307CoreApplication.class, args);

        SpringApplication springApplication = new SpringApplication(Boot307CoreApplication.class);

        springApplication.run(args);
    }

    @Bean
    public ApplicationRunner applicationRunner()
    {
        return args -> System.out.println("-------- ApplicationRunner 运行了 --------");
    }

    @Bean
    public CommandLineRunner commandLineRunner()
    {
        return args -> System.out.println("-------- CommandLineRunner 运行了 --------");
    }
}
