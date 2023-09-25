package com.myxh.springboot.features.service;

import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/23
 */
@Service
public class HelloService
{
    public Integer sum(Integer a, Integer b)
    {
        return a + b;
    }
}
