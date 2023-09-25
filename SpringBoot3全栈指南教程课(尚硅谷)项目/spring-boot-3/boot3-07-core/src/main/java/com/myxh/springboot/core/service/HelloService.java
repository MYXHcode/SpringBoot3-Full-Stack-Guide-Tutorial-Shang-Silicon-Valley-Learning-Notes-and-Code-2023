package com.myxh.springboot.core.service;

import com.myxh.springboot.core.event.LoginSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/24
 */
@Service
public class HelloService
{
    @EventListener
    public void onEvent(LoginSuccessEvent event){
        System.out.println("-------- HelloService 感知到事件 --------");
        System.out.println("event = " + event);
        System.out.println("------------------------");

        // 调用业务
    }
}
