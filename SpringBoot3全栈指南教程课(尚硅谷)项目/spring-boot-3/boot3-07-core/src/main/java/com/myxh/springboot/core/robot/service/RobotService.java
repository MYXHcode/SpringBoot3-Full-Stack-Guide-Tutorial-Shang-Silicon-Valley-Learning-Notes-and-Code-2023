package com.myxh.springboot.core.robot.service;

import com.myxh.springboot.core.robot.properties.RobotProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/24
 */
@Service
public class RobotService
{
    @Autowired
    private RobotProperties robotProperties;

    public String sayHello()
    {
        return "你好，" + robotProperties.getName();
    }
}
