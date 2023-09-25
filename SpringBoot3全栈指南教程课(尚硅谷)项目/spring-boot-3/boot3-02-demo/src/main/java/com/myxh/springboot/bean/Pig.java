package com.myxh.springboot.bean;

/**
 * @author MYXH
 * @date 2023/9/11
 */
// @Component
// @ConfigurationProperties(prefix = "pig")
public class Pig
{
    private Long id;
    private String name;
    private Integer age;

    public Pig()
    {

    }

    public Pig(Long id, String name, Integer age)
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
