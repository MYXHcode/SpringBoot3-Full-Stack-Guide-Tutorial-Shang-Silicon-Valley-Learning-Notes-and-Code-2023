package com.myxh.springboot.features;

import com.myxh.springboot.features.bean.Cat;
import com.myxh.springboot.features.bean.Dog;
import com.myxh.springboot.features.bean.Pig;
import com.myxh.springboot.features.bean.Sheep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * <br>
 * 1、标识环境
 * 1.1 区分出几个环境：dev（开发环境）、test（测试环境）、prod（生产环境）
 * 1.2 指定每个组件在哪个环境下生效，default 环境：默认环境
 *     通过：@Profile("dev") 标注
 *     组件没有标注 @Profile 代表任意时候都生效
 * 1.3 默认只有激活指定的环境，这些组件才会生效
 * <br>
 * 2、激活环境
 *    配置文件激活：spring.profiles.active=dev
 *    命令行激活：java -jar xxx.jar --spring.profiles.active=dev
 * <br>
 * 3、配置文件怎么使用 Profile 功能
 * 3.1 application.properties：主配置文件，任何情况下都生效
 * 3.2 其他 Profile 环境下命名规范：application-{profile 标识}.properties
 *     比如：application-dev.properties
 * 3.3 激活指定环境则可：配置文件激酒、命令行激活
 * 3.4 效果：
 *     项目的所有生效配置项 = 激活环境配置文件的所有项 + 主配置文件和激活文件不冲突的所有项
 *     如果发生了配置冲突，以激活的环境配置文件为准
 *     application-{profile 标识}.properties 优先级大于 application.properties
 * <br>
 *     主配置和激活的配置都生效，优先以激活的配置为准
 */
@Slf4j
/*
SpringBoot 的默认扫描规则，只扫描自己主程序所在的包以及子包

自定义 starter 所有组件包名：com.myxh.springboot.starter.robot
当前项目的主程序所在包：com.myxh.springboot.features
 */
// @Import(RobotAutoConfiguration.class)
// @EnableRobot
@SpringBootApplication
public class Boot306FeaturesApplication
{
    public static void main(String[] args)
    {
        // 1、SpringApplication：Boot 应用的核心 API 入口
        // SpringApplication.run(Boot306FeaturesApplication.class, args);

        // 1.1 自定义 SpringApplication 的底层设置
        // SpringApplication springApplication = new SpringApplication(Boot306FeaturesApplication.class);

        // 1.2 程序化调整 SpringApplication 的参数，配置文件优先级高于程序化调整的优先级
        // springApplication.setBannerMode(Banner.Mode.OFF);

        // 1.3 SpringApplication 运行起来
        // springApplication.run(args);

        // 2、Builder 方式构建 SpringApplication：通过 FluentAPI 进行设置
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder()
                .main(Boot306FeaturesApplication.class)
                .sources(Boot306FeaturesApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .properties("server.port=8080")
                .run(args);

        try
        {
            Cat cat = applicationContext.getBean(Cat.class);
            log.info("组件 cat：{}", cat);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            Dog dog = applicationContext.getBean(Dog.class);
            log.info("组件 dog：{}", dog);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            Pig pig = applicationContext.getBean(Pig.class);
            log.info("组件 pig：{}", pig);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            Sheep sheep = applicationContext.getBean(Sheep.class);
            log.info("组件 sheep：{}", sheep);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
