package com.myxh.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/11
 */
// @Controller
// @ResponseBody
@RestController
public class HelloController
{
    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello, Spring Boot 3!";
    }

    @GetMapping("/increment")
    public String increment()
    {
        Long num1 = redisTemplate.opsForValue().increment("num1");

        return "增加后的值：" + num1;
    }
}
