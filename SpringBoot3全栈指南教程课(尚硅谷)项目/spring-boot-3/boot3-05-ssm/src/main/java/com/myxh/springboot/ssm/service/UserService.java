package com.myxh.springboot.ssm.service;

import com.myxh.springboot.ssm.bean.User;

/**
 * @author MYXH
 * @date 2023/9/23
 */
public interface UserService
{
    /**
     * 根据用户 id 获取一个用户信息
     *
     * @param id 用户 id
     * @return 一个用户信息
     */
    User getUser(Long id);
}
