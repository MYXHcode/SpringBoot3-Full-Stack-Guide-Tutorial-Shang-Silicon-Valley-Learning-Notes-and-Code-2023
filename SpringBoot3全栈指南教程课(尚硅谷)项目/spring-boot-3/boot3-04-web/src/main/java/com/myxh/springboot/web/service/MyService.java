package com.myxh.springboot.web.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author MYXH
 * @date 2023/9/18
 */
@Service
public class MyService
{
    public void myService()
    {
        //当前请求路径
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        // 任意位置随时通过 RequestContextHolder 获取到当前请求和响应的信息
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        String requestURI = request.getRequestURI();
    }
}
