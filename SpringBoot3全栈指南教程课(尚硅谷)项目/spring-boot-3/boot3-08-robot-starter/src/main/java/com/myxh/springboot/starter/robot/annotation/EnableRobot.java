package com.myxh.springboot.starter.robot.annotation;

import com.myxh.springboot.starter.robot.RobotAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author MYXH
 * @date 2023/9/24
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(RobotAutoConfiguration.class)
public @interface EnableRobot
{

}
