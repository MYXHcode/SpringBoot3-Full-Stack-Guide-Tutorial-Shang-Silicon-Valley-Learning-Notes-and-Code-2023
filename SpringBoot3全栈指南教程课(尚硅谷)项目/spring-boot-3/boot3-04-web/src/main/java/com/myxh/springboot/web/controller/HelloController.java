package com.myxh.springboot.web.controller;

import com.myxh.springboot.web.bean.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MYXH
 * @date 2023/9/18
 */
@Slf4j
@RestController
public class HelloController
{
    /**
     * 默认使用新版 PathPatternParser 进行路径匹配
     * 不能匹配 ** 在中间的情况，其他情况和 antPathMatcher语法兼容
     *
     * @param request 请求
     * @param path 路径
     * @return uri
     */
    @GetMapping("/a*/b?/**/{p1:[a-f]+}/**")
    public String hello(HttpServletRequest request, @PathVariable("p1") String path)
    {
        log.info("路径变量 p1：{}", path);
        String uri = request.getRequestURI();

        return uri;
    }

    @Autowired
    private User user;

    /**
     * 1、默认支持把对象写为 json，因为默认 web 场最导入了 jackson 处理 json 的包
     * 2、jackson 也支持把数据写为 xml，导入 xml 相关依赖
     *
     * @return user
     */
    @GetMapping("/user")
    public User user()
    {
        user.setId(1L);
        user.setUserName("MYXH");
        user.setPassword("520.ILY!");
        user.setAge(21);
        user.setEmail("1735350920@qq.com");

        return user;
    }

    /*
    public static void main(String[] args) throws JsonProcessingException
    {
        User user = new User();
        user.setId(1L);
        user.setUserName("MYXH");
        user.setPassword("520.ILY!");
        user.setAge(21);
        user.setEmail("1735350920@qq.com");

        YAMLFactory factory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper mapper = new ObjectMapper(factory);

        String userYaml = mapper.writeValueAsString(user);
        System.out.println("userYaml = " + userYaml);
    }
     */
}
