package com.myxh.springboot.core.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/24
 * @description 事件是广播出去的，所有监听这个事件的监听器都可以收到
 */
@Service
public class EventPublisher implements ApplicationEventPublisherAware
{
    // 底层发送事件用的组件，SpringBoot 会通过 ApplicationEventPublisherAware 接口自动注入
    ApplicationEventPublisher applicationEventPublisher;

    /**
     * 所有事件都可以发
     *
     * @param event 事件
     */
    public void sendEvent(ApplicationEvent event)
    {
        // 调用底层 API 发送事件
        applicationEventPublisher.publishEvent(event);
    }

    /**
     * 会被自动调用，把真正发事件的底层组组件给注入进来
     *
     * @param applicationEventPublisher 此对象要使用的事件发布者
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher)
    {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
