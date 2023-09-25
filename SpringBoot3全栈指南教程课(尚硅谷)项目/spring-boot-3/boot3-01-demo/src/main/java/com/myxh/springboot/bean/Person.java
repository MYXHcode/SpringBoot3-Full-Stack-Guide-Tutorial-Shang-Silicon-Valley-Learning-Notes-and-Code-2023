package com.myxh.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/11
 */
@Component
// 和配置文件 person 前缀的所有配置进行绑定
@ConfigurationProperties(prefix = "person")
// 自动生成无参构造器
@NoArgsConstructor
// 自动生成全参构造器
@AllArgsConstructor
// 自动生成 JavaBean 属性的 getter/setter
@Data
public class Person
{
    private String name;
    private Integer age;
    private Date birthDay;
    private Boolean like;
    // 嵌套对象
    private Child child;
    // 数组（里面是对象）
    private List<Dog> dogs;
    // Map
    private Map<String, Cat> cats;
}
