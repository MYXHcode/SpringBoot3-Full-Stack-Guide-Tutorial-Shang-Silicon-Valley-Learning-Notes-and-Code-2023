package com.myxh.springboot.features.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/23
 */
@RestController
public class HelloController
{
    @Value("${my.server.port:我的服务端口是：8080，我的用户名是：末影小黑xh}")
    String port;

    @GetMapping("/hello")
    public String hello()
    {
        return port;
    }
}
