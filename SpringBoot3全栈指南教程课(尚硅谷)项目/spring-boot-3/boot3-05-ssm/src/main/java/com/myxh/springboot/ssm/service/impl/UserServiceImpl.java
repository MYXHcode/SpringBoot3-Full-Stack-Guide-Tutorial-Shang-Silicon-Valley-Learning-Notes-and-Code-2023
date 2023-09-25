package com.myxh.springboot.ssm.service.impl;

import com.myxh.springboot.ssm.bean.User;
import com.myxh.springboot.ssm.mapper.UserMapper;
import com.myxh.springboot.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MYXH
 * @date 2023/9/23
 */
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户 id 获取一个用户信息
     *
     * @param id 用户 id
     * @return 一个用户信息
     */
    @Override
    public User getUser(Long id)
    {
        User user = userMapper.getUserById(id);

        return user;
    }
}
