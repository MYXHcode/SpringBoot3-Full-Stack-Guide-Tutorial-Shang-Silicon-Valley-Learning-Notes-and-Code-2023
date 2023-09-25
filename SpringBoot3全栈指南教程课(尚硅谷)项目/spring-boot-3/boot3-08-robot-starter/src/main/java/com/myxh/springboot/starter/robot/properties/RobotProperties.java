package com.myxh.springboot.starter.robot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/24
 */
// 此属性类和配置文件指定前缀绑定
@ConfigurationProperties(prefix = "robot")
@Component
@Data
public class RobotProperties
{
    private String name;
    private Integer age;
    private String email;
}
