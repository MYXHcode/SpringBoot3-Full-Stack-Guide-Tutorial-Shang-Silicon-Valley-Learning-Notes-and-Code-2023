package com.myxh.springboot.web.controller;

import com.myxh.springboot.web.bean.User;
import com.myxh.springboot.web.service.MyService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author MYXH
 * @date 2023/9/18
 */
//适配服务端清染，前后不分离模式
@Controller
public class WelcomeController
{
    @Autowired
    MyService myService;

    /**
     * 利用模板引擎跳转到指定页面
     *
     * @return welcome
     */
    @GetMapping("/welcome")
    public String hello(@RequestParam("name") String name, Model model)
    {
        // 把需要给页面共享的数据放到 model 中
        String text = "<span style='color:blue'>"+name+"</span>";
        model.addAttribute("message",text);

        // 路径是动态的
        model.addAttribute("imageUrl", "/大户爱.png");

        // 数据库查出的样式
        model.addAttribute("style","width: 400px");

        model.addAttribute("show", true);

        model.addAttribute("name",name);

        myService.myService();

        /*
        模板的逻辑视图名
        物理视图 = 前缓 + 逻视图名 + 后缓
        真实地址 = classpath:/templates/welcome.html
         */
        return "welcome";
    }

    /**
     * 来到首页
     *
     * @return index
     */
    @GetMapping("/index")
    public String index()
    {
        return "index";
    }

    @GetMapping("/userList")
    public String userList(Model model)
    {
        List<User> userList = Arrays.asList(
                new User(1L, "MYXH","520.ILY!",21,"1735350920@qq.com","root"),
                new User(2L, "root","000000",21,"root@qq.com","root"),
                new User(3L, "admin","123456",21,"admin@qq.com","admin"),
                new User(4L, "test","test",18,"test@qq.com","test"),
                new User(5L, "张三","123456",18,"","user")
        );

        model.addAttribute("userList", userList);

        // int n = 10 / 0;

        return "userList";
    }

    // 国际化获取消息的组件
    @Autowired
    MessageSource messageSource;

    @GetMapping("/message")
    @ResponseBody
    public String message(HttpServletRequest request)
    {
        Locale locale = request.getLocale();

        // 利用代码的方式获取国际化配置文件中指定的配置项的值
        String login = messageSource.getMessage("login", null, locale);

        return login;
    }
}
