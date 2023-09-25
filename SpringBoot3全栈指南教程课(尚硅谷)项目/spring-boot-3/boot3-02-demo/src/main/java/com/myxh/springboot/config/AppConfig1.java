package com.myxh.springboot.config;

import com.alibaba.druid.FastsqlException;
import com.myxh.springboot.bean.Pig;
import com.myxh.springboot.bean.Sheep;
import com.myxh.springboot.bean.User;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @author MYXH
 * @date 2023/9/11
 */
// 给容器中放指定类型的组件，组件的名字默认是全类名
@Import(FastsqlException.class)
// 这是一个配置类，替代以前的配置文件，配置类本身也是容器中的组件
// @Configuration
@SpringBootConfiguration
// 导入第三方写好的组件进行属性绑定，SpringBoot 默认只扫描自己主程序所在的包，如果导入第三方包，即使组件上标注了 @Component、@ConfigurationProperties 注解也没用，因为组件都扫描不进来
// 1、开启 Sheep 组件的属性绑定
// 2、默认会把这个组件自己放到容器中
@EnableConfigurationProperties(Sheep.class)
public class AppConfig1
{
    /**
     * 1、组件默认是单实例的
     *
     * @return userBean
     */
    // 替代以前的 Bean 标签，组件在容器中的名字默认是方法名，可以直接修改注解的值
    @Bean("userBean")
    @Scope("prototype")
    public User userBean()
    {
        var user = new User();
        user.setId(1L);
        user.setName("MYXH");

        return user;
    }

    /*
    @Bean
    public FastsqlException fastException()
    {
        return new FastsqlException();
    }
     */

    @Bean
    @ConfigurationProperties(prefix = "pig")
    public Pig pig()
    {
        // 自己 new 的新 pig
        return new Pig();
    }
}
