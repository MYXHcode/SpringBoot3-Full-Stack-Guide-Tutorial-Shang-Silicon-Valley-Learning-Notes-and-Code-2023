package com.myxh.springboot.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/14
 */
@Slf4j
@RestController
public class HelloController
{
    // Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello")
    public String hello(String a, String b)
    {
        // SpringBoot 底层默认的日志级别 info
        log.trace("trace 日志......");
        log.debug("debug 日志......");
        log.info("info 日志...... 参数 a：{} 参数 b：{}",a, b);
        log.warn("warn 日志......");
        log.error("error 日志......");

        // logger.info("方法进来了");
        log.info("方法进来了");

        return "hello";
    }
}
