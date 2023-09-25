package com.myxh.springboot.ssm.mapper;

import com.myxh.springboot.ssm.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author MYXH
 * @date 2023/9/23
 */
public interface UserMapper
{
    /**
     * 根据用户 id 获取一个用户信息
     * 1、每个方法都在 Mapper 文件中有一个 sql 标签对应
     * 2、所有参数都应该用 @Param 进行签名，以后使用指定的名字在 SQL 中取值
     *
     * @param id 用户 id
     * @return 一个用户信息
     */
    User getUserById(@Param("id") Long id);
}
