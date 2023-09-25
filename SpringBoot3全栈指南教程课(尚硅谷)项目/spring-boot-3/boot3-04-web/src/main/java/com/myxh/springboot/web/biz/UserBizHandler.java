package com.myxh.springboot.web.biz;

import com.myxh.springboot.web.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.Arrays;
import java.util.List;

/**
 * @author MYXH
 * @date 2023/9/18
 * @description 专门处理 User 有关的业务
 */
@Slf4j
@Service
public class UserBizHandler
{
    @Autowired
    private User user;

    /**
     * 查询指定 id 的用户
     *
     * @param request 请求
     * @return response 响应
     * @throws Exception 异常
     */
    public ServerResponse getUser(ServerRequest request) throws Exception
    {
        // 业务处理
        String id = request.pathVariable("id");

        user.setId(1L);
        user.setUserName("MYXH");
        user.setPassword("520.ILY!");
        user.setAge(21);
        user.setEmail("1735350920@qq.com");

        log.info("查询 {} 号用户信息成功", id);

        // 构造响应
        ServerResponse response = ServerResponse
                .ok()
                // 凡是 body 中的对象，就是以前 @ResponseBody 原理，利用 HttpMessageConverter 写出为 json
                .body(user);

        return response;
    }

    /**
     * 获取所有用户
     *
     * @param request 请求
     * @return response 响应
     * @throws Exception 异常
     */
    public ServerResponse getUsers(ServerRequest request) throws Exception
    {
        // 业务处理
        List<User> userList = Arrays.asList(
                new User(1L, "MYXH","520.ILY!",21,"1735350920@qq.com","root"),
                new User(2L, "root","000000",21,"root@qq.com","root"),
                new User(3L, "admin","123456",21,"admin@qq.com","admin"),
                new User(4L, "test","test",18,"test@qq.com","test"),
                new User(5L, "张三","123456",18,"","user")
        );

        log.info("查询所有用户信息成功");

        // 构造响应
        ServerResponse response = ServerResponse
                .ok()
                .body(userList);

        return response;
    }

    /**
     * 保存用户
     *
     * @param request 请求
     * @return response 响应
     * @throws Exception 异常
     */
    public ServerResponse saveUser(ServerRequest request) throws Exception
    {
        // 业务处理
        // 提取请求体
        User body = request.body(User.class);

        log.info("保存用户信息成功，用户信息：{}", body);

        // 构造响应
        ServerResponse response = ServerResponse
                .ok()
                .build();

        return response;
    }

    /**
     * 更新指定 id 的用户
     *
     * @param request 请求
     * @return response 响应
     * @throws Exception 异常
     */
    public ServerResponse updateUser(ServerRequest request) throws Exception
    {
        // 业务处理
        // 提取请求体
        User body = request.body(User.class);

        log.info("更新用户信息成功，用户信息：{}", body);

        // 构造响应
        ServerResponse response = ServerResponse
                .ok()
                .build();

        return response;
    }

    /**
     * 删除指定 id 的用户
     *
     * @param request 请求
     * @return response 响应
     * @throws Exception 异常
     */
    public ServerResponse deleteUser(ServerRequest request) throws Exception
    {
        // 业务处理
        String id = request.pathVariable("id");

        log.info("删除 {} 号用户信息成功", id);

        // 构造响应
        ServerResponse response = ServerResponse
                .ok()
                .build();

        return response;
    }
}
