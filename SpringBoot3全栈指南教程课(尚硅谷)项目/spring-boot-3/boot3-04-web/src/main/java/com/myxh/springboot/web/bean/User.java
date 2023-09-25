package com.myxh.springboot.web.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/18
 */
// 可以写出为 xml 文档
@JacksonXmlRootElement
@Component
// 和配置文件 person 前缀的所有配置进行绑定
@ConfigurationProperties(prefix = "user")
// 自动生成无参构造器
@NoArgsConstructor
// 自动生成全参构造器
@AllArgsConstructor
// 自动生成 JavaBean 属性的 getter/setter
@Data
public class User
{
    private Long id;
    private String userName;
    private String password;
    private Integer age;
    private String email;
    private String role;
}
