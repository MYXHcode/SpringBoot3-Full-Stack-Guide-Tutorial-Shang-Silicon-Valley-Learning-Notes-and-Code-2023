package com.myxh.springboot.core.event;

import com.myxh.springboot.core.entity.UserEntity;
import org.springframework.context.ApplicationEvent;

/**
 * @author MYXH
 * @date 2023/9/24
 * @description 登录成功事件，所有事件都推荐继承 ApplicationEvent
 */
public class LoginSuccessEvent extends ApplicationEvent
{
    /**
     * 登录成功事件
     *
     * @param source 事件来源，代表是谁登录成了
     */
    public LoginSuccessEvent(UserEntity source)
    {
        super(source);
    }
}
