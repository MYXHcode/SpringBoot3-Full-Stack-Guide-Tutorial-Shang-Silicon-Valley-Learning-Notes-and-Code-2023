package com.myxh.springboot.core.robot.controller;

import com.myxh.springboot.core.robot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/24
 */
@RestController
public class RobotController
{
    @Autowired
    RobotService robotService;

    @GetMapping("/robot/hello")
    public String sayHello()
    {
        String sayHello = robotService.sayHello();

        return sayHello;
    }
}
