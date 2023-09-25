package com.myxh.springboot.core.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author MYXH
 * @date 2023/9/24
 */
public class MyListener implements ApplicationListener<ApplicationEvent>
{
    @Override
    public void onApplicationEvent(ApplicationEvent event)
    {
        System.out.println("-------- 事件到达 --------");
        System.out.println("event = " + event);
        System.out.println("------------------------");
    }
}
