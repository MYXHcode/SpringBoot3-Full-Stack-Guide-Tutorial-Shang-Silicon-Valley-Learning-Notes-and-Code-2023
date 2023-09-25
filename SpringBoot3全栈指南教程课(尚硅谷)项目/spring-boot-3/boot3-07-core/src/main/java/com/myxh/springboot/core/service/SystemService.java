package com.myxh.springboot.core.service;

import com.myxh.springboot.core.entity.UserEntity;
import com.myxh.springboot.core.event.LoginSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/24
 */
@Service
public class SystemService
{
    @Order(1)
    @EventListener
    public void onEvent(LoginSuccessEvent event)
    {
        System.out.println("-------- SystemService 感知到事件 --------");
        System.out.println("event = " + event);
        System.out.println("------------------------");
        UserEntity source = (UserEntity) event.getSource();
        recordLog(source.getUsername());
    }

    public void recordLog(String username)
    {
        System.out.println(username + "登录信息已被记录");
    }
}
