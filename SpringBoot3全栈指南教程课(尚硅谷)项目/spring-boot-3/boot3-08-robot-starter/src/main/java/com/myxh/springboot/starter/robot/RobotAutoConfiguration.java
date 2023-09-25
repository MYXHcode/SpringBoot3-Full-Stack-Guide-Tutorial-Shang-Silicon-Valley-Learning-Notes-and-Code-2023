package com.myxh.springboot.starter.robot;

import com.myxh.springboot.starter.robot.controller.RobotController;
import com.myxh.springboot.starter.robot.properties.RobotProperties;
import com.myxh.springboot.starter.robot.service.RobotService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author MYXH
 * @date 2023/9/24
 */
// 给容器中导入 Robot 功能要用的所有组件
@Import({RobotProperties.class, RobotController.class, RobotService.class})
@Configuration
public class RobotAutoConfiguration
{
    /*
    // 把组件导入到容器中
    @Bean
    public RobotController robotController()
    {
        return new RobotController();
    }
     */
}
