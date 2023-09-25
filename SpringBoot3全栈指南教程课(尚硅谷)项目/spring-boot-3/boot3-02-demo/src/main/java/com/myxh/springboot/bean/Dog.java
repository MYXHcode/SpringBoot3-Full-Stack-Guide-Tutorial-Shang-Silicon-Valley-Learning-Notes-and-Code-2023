package com.myxh.springboot.bean;

import org.springframework.stereotype.Component;

/**
 * @author MYXH
 * @date 2023/9/11
 */
@Component
public class Dog
{
    private Long id;
    private String name;

    public Dog()
    {

    }

    public Dog(Long id, String name)
    {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
