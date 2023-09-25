package com.myxh.springboot;

import com.alibaba.druid.FastsqlException;
import com.myxh.springboot.bean.Cat;
import com.myxh.springboot.bean.Dog;
import com.myxh.springboot.bean.Sheep;
import com.myxh.springboot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot302DemoApplication
{
    public static void main(String[] args)
    {
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
        String[] beanNames = ioc.getBeanDefinitionNames();

        for (String beanName : beanNames)
        {
            System.out.println("beanName = " + beanName);
        }

        String[] beanNamesForType1 = ioc.getBeanNamesForType(User.class);

        for (String beanNameForType1 : beanNamesForType1)
        {
            System.out.println("beanNameForType1 = " + beanNameForType1);
        }

        Object userBean1 = ioc.getBean("userBean");
        Object userBean2 = ioc.getBean("userBean");
        System.out.println("userBean1 == userBean2 = " + (userBean1 == userBean2));

        String[] beanNamesForType2 = ioc.getBeanNamesForType(FastsqlException.class);

        for (String beanNameForType2 : beanNamesForType2)
        {
            System.out.println("beanNameForType2 = " + beanNameForType2);
        }

        String[] beanNamesForType3 = ioc.getBeanNamesForType(Cat.class);

        for (String beanNameForType3 : beanNamesForType3)
        {
            System.out.println("cat = " + beanNameForType3);
        }

        String[] beanNamesForType4 = ioc.getBeanNamesForType(Dog.class);

        for (String beanNameForType4 : beanNamesForType4)
        {
            System.out.println("dog = " + beanNameForType4);
        }

        Object pig = ioc.getBean("pig");
        System.out.println("pig = " + pig);

        Object sheep = ioc.getBean(Sheep.class);
        System.out.println("sheep = " + sheep);
    }
}
