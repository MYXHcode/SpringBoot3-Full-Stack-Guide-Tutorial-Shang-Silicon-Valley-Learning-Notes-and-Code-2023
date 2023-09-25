package com.myxh.springboot.ssm.controller;

import com.myxh.springboot.ssm.bean.User;
import com.myxh.springboot.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/23
 */
@RestController
public class UserController
{
    @Autowired
    UserService userService;

    /**
     * 根据用户 id 获取一个用户信息，返回 User 的 json 数据
     *
     * @param id 用户 id
     * @return 一个用户信息
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id)
    {
        User user = userService.getUser(id);

        return user;
    }
}
