package com.myxh.springboot.web.config;

import com.myxh.springboot.web.biz.UserBizHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @author MYXH
 * @date 2023/9/18
 * @description
 * 场景：User RESTful - CRUD
 * GET /user/1 获取 1 号用户
 * GET /users 获取所有用户
 * POST /user 请求体携带 JSON，新增一个用户
 * PUT /user/1 请求体携带 JSON，修改 1 号用户
 * DELETE /user/1 删除 1 号用户
 */
@Configuration
public class WebFunctionConfig
{
    /**
     * 函数式 Web
     * 1、给容器中放一个 Bean: 类型是 RouterFunction<ServerResponse>，集中所有路由信息
     * 2、每个业务准备一个自己的 Handler
     * <br>
     * 核心四大对象
     * 1、RouterFunction：定义路由信息，发什么请求，谁来处理
     * 2、RequestPredicate：定义请求，请求谓语，请求方式（GET、POST），请求参数
     * 3、ServerRequest：封装请求完整数据
     * 4、ServerResponse：封装响应完整数据
     *
     * @param userBizHandler 用户业务处理程序（userBizHandler 会被自动注入进来）
     * @return routerFunction 路由器功能
     */
    @Bean
    public RouterFunction<ServerResponse> userRouter(UserBizHandler userBizHandler)
    {
        // 开始定义路由信息
        RouterFunction<ServerResponse> routerFunction = RouterFunctions.route()
                .GET("/user/{id}", RequestPredicates.accept(MediaType.ALL), userBizHandler::getUser)
                .GET("/users", userBizHandler::getUsers)
                .POST("/user", RequestPredicates.accept(MediaType.APPLICATION_JSON), userBizHandler::saveUser)
                .PUT("/user{id}", RequestPredicates.accept(MediaType.APPLICATION_JSON), userBizHandler::updateUser)
                .DELETE("/user{id}", userBizHandler::deleteUser)
                .build();

        return routerFunction;
    }
}
