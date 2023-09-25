package com.myxh.springboot.core.controller;

import com.myxh.springboot.core.entity.UserEntity;
import com.myxh.springboot.core.event.EventPublisher;
import com.myxh.springboot.core.event.LoginSuccessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/24
 */
@RestController
public class LoginController
{
    /*
    @Autowired
    private AccountService accountService;

    @Autowired
    private CouponService couponService;

    @Autowired
    private SystemService systemService;
     */

    @Autowired
    private EventPublisher eventPublisher;

    /**
     * 增加业务
     *
     * @param username 用户名
     * @param password 密码
     * @return username 登陆成功
     */
    @GetMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        // 业务处理登录
        System.out.println("业务处理登录完成");

        // TODO 发送事件
        LoginSuccessEvent loginSuccessEvent = new LoginSuccessEvent(new UserEntity("MYXH", "520.ILY!"));

        eventPublisher.sendEvent(loginSuccessEvent);

        // 1、账户服务自动签到加积分
        // accountService.addAccountScore(username);

        // 2、优惠服务随机发放优惠券
        // couponService.sendCoupon(username);

        // 3、系统服务登记用户登录的信息
        // systemService.recordLog(username);

        // 设计模式：对新增开放，对修改关闭
        // xxx
        // xxx
        // xxx

        return username + "登陆成功";
    }
}
