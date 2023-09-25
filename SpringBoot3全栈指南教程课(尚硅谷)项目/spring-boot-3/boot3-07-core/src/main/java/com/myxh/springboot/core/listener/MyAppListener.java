package com.myxh.springboot.core.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * @author MYXH
 * @date 2023/9/24
 * @description
 * SpringBoot 应用生命周期监听
 * <br>
 * Listener先要从 META-INF/spring.factories 读到
 * <br>
 * 1、引导：利用 BootstrapContext 引导整个项目启动
 *         starting：               应用开始，SpringApplication 的 run 方法一调用，只要有了 BootstrapContext 就执行
 *         environmentPrepared：    环境准备好（把启动参数等绑定到环境变量中），但是 ioc 还没有创建（调一次）
 * 2、启动：
 *        contextPrepared：         ioc 容器创建并准备好，但是 sources（主配置类）没加载，并关闭引导上下文，组件都没创建（调一次）
 *        contextLoaded：           ioc 容器加载，主配置类加载进去了，但是 ioc 容器还没刷新（bean 没创建）
 *        ----- 截止现在，ioc 容器里面还没造 bean -----
 *        started：                 ioc 容器刷新了（所有 bean 造好了），但是 runner 没调用
 *        ready：                   ioc 容器刷新了（所有 bean 造好了），所有 runner 调用完了
 * 3、运行：
 *       以上步骤都正确执行，代表容器 running。
 */
public class MyAppListener implements SpringApplicationRunListener
{
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext)
    {
        System.out.println("--------------- starting() 正在启动 ---------------");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment)
    {
        System.out.println("--------------- environmentPrepared() 环境准备完成 ---------------");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context)
    {
        System.out.println("--------------- contextPrepared() ioc 容器准备完成 ---------------");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context)
    {
        System.out.println("--------------- contextLoaded() ioc 容器加载完成 ---------------");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken)
    {
        System.out.println("--------------- started() 启动完成 ---------------");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken)
    {
        System.out.println("--------------- ready() 准备就绪 ---------------");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception)
    {
        System.out.println("--------------- failed() 应用启动失败 ---------------");
    }
}
