package com.myxh.springboot.core.service;

import com.myxh.springboot.core.entity.UserEntity;
import com.myxh.springboot.core.event.LoginSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/24
 */
@Order(2)
@Service
public class AccountService implements ApplicationListener<LoginSuccessEvent>
{
    public void addAccountScore(String username)
    {
        System.out.println(username + " 加了 1 分");
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event)
    {
        System.out.println("-------- AccountService  收到事件 --------");
        UserEntity source = (UserEntity) event.getSource();
        addAccountScore(source.getUsername());
    }
}
