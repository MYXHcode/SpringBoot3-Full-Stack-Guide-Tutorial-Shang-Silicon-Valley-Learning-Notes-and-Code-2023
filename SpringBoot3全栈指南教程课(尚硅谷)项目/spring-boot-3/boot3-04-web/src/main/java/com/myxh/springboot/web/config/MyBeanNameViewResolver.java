package com.myxh.springboot.web.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

/**
 * @author MYXH
 * @date 2023/9/18
 */
@Component("myBeanName")
public class MyBeanNameViewResolver implements View
{
    @Override
    public String getContentType()
    {
        return View.super.getContentType();
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        response.getWriter().write("myBeanName");
    }
}
