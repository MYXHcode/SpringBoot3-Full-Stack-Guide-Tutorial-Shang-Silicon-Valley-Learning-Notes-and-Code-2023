package com.myxh.springboot.core.service;

import com.myxh.springboot.core.entity.UserEntity;
import com.myxh.springboot.core.event.LoginSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/24
 */
@Service
public class CouponService
{
    public CouponService()
    {
        System.out.println("构造器调用");
    }

    @Async
    @Order(3)
    @EventListener
    public void onEvent(LoginSuccessEvent loginSuccessEvent)
    {
        System.out.println("-------- CouponService 感知到事件 --------");
        System.out.println("loginSuccessEvent = " + loginSuccessEvent);
        System.out.println("------------------------");
        UserEntity source = (UserEntity) loginSuccessEvent.getSource();
        sendCoupon(source.getUsername());
    }

    public void sendCoupon(String username)
    {
        System.out.println(username + " 随机得到了一张优惠券");
    }
}
