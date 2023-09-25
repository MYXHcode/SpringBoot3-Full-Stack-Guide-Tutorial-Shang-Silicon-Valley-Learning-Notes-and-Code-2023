package com.myxh.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author MYXH
 * @date 2023/9/11
 */
// @Component
@ConfigurationProperties(prefix = "sheep")
public class Sheep
{
    private Long id;
    private String name;
    private Integer age;

    public Sheep()
    {

    }

    public Sheep(Long id, String name, Integer age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Pig{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
